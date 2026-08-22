package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

/**
 * Tipo de retencao do PIS/COFINS (TSTipoRetPISCofins do layout).
 *
 * A tabela oficial vai de 0 a 9 e combina PIS, COFINS e CSLL. Quando o tipo indica CSLL retida,
 * a SEFIN passa a exigir o campo vRetCSLL (rejeicao E0724).
 */
public enum NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao {

    PIS_COFINS_CSLL_NAO_RETIDOS("0", "PIS/COFINS/CSLL Nao Retidos"),
    PIS_COFINS_RETIDOS("1", "PIS/COFINS Retidos"),
    PIS_COFINS_NAO_RETIDOS("2", "PIS/COFINS Nao Retidos"),
    PIS_COFINS_CSLL_RETIDOS("3", "PIS/COFINS/CSLL Retidos"),
    PIS_COFINS_RETIDOS_CSLL_NAO("4", "PIS/COFINS Retidos, CSLL Nao Retido"),
    PIS_RETIDO_COFINS_CSLL_NAO("5", "PIS Retido, COFINS/CSLL Nao Retido"),
    COFINS_RETIDO_PIS_CSLL_NAO("6", "COFINS Retido, PIS/CSLL Nao Retido"),
    PIS_NAO_RETIDO_COFINS_CSLL_RETIDOS("7", "PIS Nao Retido, COFINS/CSLL Retidos"),
    PIS_COFINS_NAO_RETIDOS_CSLL_RETIDO("8", "PIS/COFINS Nao Retidos, CSLL Retido"),
    COFINS_NAO_RETIDO_PIS_CSLL_RETIDOS("9", "COFINS Nao Retido, PIS/CSLL Retidos");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao valor : values()) {
            if (valor.getCodigo().equals(codigo)) {
                return valor;
            }
        }
        return null;
    }
}
