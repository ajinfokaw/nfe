package com.fincatto.documentofiscal.nfse.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.nfse.NFSeConfig;
import com.fincatto.documentofiscal.nfse.classes.nfsenacional.*;
import com.fincatto.documentofiscal.nfse.utils.NFSeDPSUtils;
import com.fincatto.documentofiscal.nfse.utils.NFSeEventoUtils;
import com.fincatto.documentofiscal.nfse.utils.NFSeHttpClient;
import com.fincatto.documentofiscal.nfse.utils.NFSeObjectMapper;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;

import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class WSSefinNFSe implements DFLog {

    // todo: adicionar URL de produção quando liberar
    public static final String URL_BASE_PRODUCAO = "https://sefin.nfse.gov.br/sefinnacional";
    public static final String URL_BASE_HOMOLOGACAO = "https://sefin.producaorestrita.nfse.gov.br/sefinnacional";
    private static final String URL_HOMOLOGACAO_NFSE = URL_BASE_HOMOLOGACAO + "/nfse";
    private static final String URL_HOMOLOGACAO_DPS = URL_BASE_HOMOLOGACAO + "/dps";

    private final NFSeObjectMapper objectMapper = new NFSeObjectMapper();
    private final NFSeConfig config;


    public WSSefinNFSe(final NFSeConfig config) {
        this.config = config;
//        this.client = ;
    }

    /**
     * Consulta NFSe pela chave de acesso
     * @param nfseChaveAcesso
     * @return objeto de resposta da consulta
     * @throws Exception
     */
    public NFSeSefinNacionalGetResponse getNFSeByChaveAcesso(final String nfseChaveAcesso) throws Exception {
        final URI urlHomologacao = new URI(String.format("%s/%s", URL_HOMOLOGACAO_NFSE, nfseChaveAcesso));
        final NFSeHttpClient.NFSeHttpResponse<String> response = new NFSeHttpClient(config).sendGetRequest(urlHomologacao);
        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalGetResponse.class);
    }

    /**
     * Recupera a chave de acesso da NFS-e gerada a partir de um DPS ja processado (GET /dps/{id}).
     *
     * Serve para reconciliar emissoes em que a resposta se perdeu: com o Id do DPS
     * ({@link com.fincatto.documentofiscal.nfse.utils.NFSeDPSUtils#gerarId}) descobre-se a chave e,
     * com ela, o XML da nota. Por sigilo fiscal a SEFIN so responde se o certificado da conexao for
     * de um ator da nota (prestador, tomador ou intermediario).
     *
     * @param idDps identificador do DPS (DPS + municipio + inscricao federal + serie + numero)
     * @return chave de acesso da NFS-e, ou null quando nao ha nota gerada para esse DPS
     */
    public String getChaveAcessoByIdDps(final String idDps) throws Exception {
        final URI url = new URI(String.format("%s/%s", URL_HOMOLOGACAO_DPS, idDps));
        final NFSeHttpClient.NFSeHttpResponse<String> response = new NFSeHttpClient(config).sendGetRequest(url);
        if (response.statusCode() == 404) {
            return null;
        }
        if (response.statusCode() != 200) {
            throw new IllegalStateException(String.format("Erro ao consultar a DPS %s. HTTP %s: %s",
                    idDps, response.statusCode(), response.body()));
        }
        final com.fasterxml.jackson.databind.JsonNode raiz = this.objectMapper.readTree(response.body());
        // A API responde com a chave em "chaveAcesso"; o texto puro tambem e aceito por seguranca.
        final com.fasterxml.jackson.databind.JsonNode chave = raiz.get("chaveAcesso");
        return chave != null && !chave.isNull() ? chave.asText() : raiz.asText(null);
    }

    /**
     * Emite NFSe a partir do DPS
     */
    public NFSeSefinNacionalPostResponseSucesso emitirNFSeByDPS(final NFSeSefinNacionalDPS dps) throws Exception {
        // Gera o id e seta no objeto para preenchimento no xml
        dps.getInfDPS().setId(NFSeDPSUtils.gerarId(dps));

        byte[] gzipped;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             java.util.zip.GZIPOutputStream gos = new java.util.zip.GZIPOutputStream(baos)) {
            gos.write(new DFAssinaturaDigital(this.config).setOmitirDeclaracaoXML(false).setUsarIdComoReferencia(false).assinarDocumento(dps.toXml()).getBytes(StandardCharsets.UTF_8));
            gos.finish();
            gzipped = baos.toByteArray();
        };

        final NFSeHttpClient.NFSeHttpResponse<String> response = new NFSeHttpClient(config).sendPostRequest(new URI(String.format("%s", URL_HOMOLOGACAO_NFSE)), String.format("{dpsXmlGZipB64:\"%s\"}", Base64.getEncoder().encodeToString(gzipped)));
        if (response.statusCode() != 201) {
            final NFSeSefinNacionalPostResponseErro responseError = this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalPostResponseErro.class);
            throw new IllegalStateException(String.format("Erro ao enviar DPS. Erros: %s", responseError.getErros()));
        }

        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalPostResponseSucesso.class);
    }

    /**
     * Emite um evento de cancelamento para uma NFSe
     */
    public NFSeSefinNacionalPostResponseSucesso enviarPedidoRegistroEvento(final NFSeSefinNacionalPedRegEvt pedidoRegistroEvento) throws Exception {
        // Gera o id e seta no objeto para preenchimento no xml
        pedidoRegistroEvento.getInfPedReg().setId(NFSeEventoUtils.gerarId(pedidoRegistroEvento));

        byte[] gzipped;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             java.util.zip.GZIPOutputStream gos = new java.util.zip.GZIPOutputStream(baos)) {
            gos.write(new DFAssinaturaDigital(this.config).setOmitirDeclaracaoXML(false).setUsarIdComoReferencia(false).assinarDocumento(pedidoRegistroEvento.toXml(), "infPedReg").getBytes(StandardCharsets.UTF_8));
            gos.finish();
            gzipped = baos.toByteArray();
        }

        final URI urlHomologacao = new URI(String.format("%s/%s/eventos", URL_HOMOLOGACAO_NFSE, pedidoRegistroEvento.getInfPedReg().getChaveAcessoNFSE()));
        final NFSeHttpClient.NFSeHttpResponse<String> response = new NFSeHttpClient(config).sendPostRequest(urlHomologacao, String.format("{pedidoRegistroEventoXmlGZipB64:\"%s\"}", Base64.getEncoder().encodeToString(gzipped)));

        if (response.statusCode() != 201) {
            final NFSeSefinNacionalPostResponseErro responseError = this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalPostResponseErro.class);
            throw new IllegalStateException(String.format("Erro ao enviar pedido de registro de evento. Erros: %s", responseError.getErros()));
        }

        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalPostResponseSucesso.class);
    }
}
