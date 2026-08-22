package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Grupo IBS/CBS da DPS ({@code IBSCBS}), conforme TCRTCInfoIBSCBS do layout 1.01 (RTC).
 *
 * O grupo é opcional na DPS, mas quando informado exige finNFSe, cIndOp, indDest e valores.
 * Os grupos de exceção (operação com entes governamentais, imóveis, reembolso/repasse/ressarcimento
 * e referência a outra NFS-e) ainda não estão mapeados.
 */
@Root(name = "IBSCBS")
public class NFSeSefinNacionalRTCInfoIBSCBS {

    @Element(name = "finNFSe")
    protected NFSeSefinNacionalRTCFinalidadeNFSe finalidadeNFSe;
    @Element(name = "indFinal", required = false)
    protected NFSeSefinNacionalRTCIndicadorUsoConsumoPessoal indicadorUsoConsumoPessoal;
    @Element(name = "cIndOp")
    protected String codigoIndicadorOperacao;
    @Element(name = "indDest")
    protected NFSeSefinNacionalRTCIndicadorDestinatario indicadorDestinatario;
    @Element(name = "valores")
    protected NFSeSefinNacionalRTCInfoValoresIBSCBS valores;

    /**
     * @return Finalidade da emissão da NFS-e.
     */
    public NFSeSefinNacionalRTCFinalidadeNFSe getFinalidadeNFSe() {
        return finalidadeNFSe;
    }

    /**
     * @param finalidadeNFSe Finalidade da emissão da NFS-e.
     */
    public NFSeSefinNacionalRTCInfoIBSCBS setFinalidadeNFSe(NFSeSefinNacionalRTCFinalidadeNFSe finalidadeNFSe) {
        this.finalidadeNFSe = finalidadeNFSe;
        return this;
    }

    /**
     * @return Indicador de operação de uso ou consumo pessoal.
     */
    public NFSeSefinNacionalRTCIndicadorUsoConsumoPessoal getIndicadorUsoConsumoPessoal() {
        return indicadorUsoConsumoPessoal;
    }

    /**
     * @param indicadorUsoConsumoPessoal Indicador de operação de uso ou consumo pessoal.
     */
    public NFSeSefinNacionalRTCInfoIBSCBS setIndicadorUsoConsumoPessoal(NFSeSefinNacionalRTCIndicadorUsoConsumoPessoal indicadorUsoConsumoPessoal) {
        this.indicadorUsoConsumoPessoal = indicadorUsoConsumoPessoal;
        return this;
    }

    /**
     * @return Código indicador da operação de fornecimento (6 dígitos).
     */
    public String getCodigoIndicadorOperacao() {
        return codigoIndicadorOperacao;
    }

    /**
     * @param codigoIndicadorOperacao Código indicador da operação de fornecimento (6 dígitos).
     */
    public NFSeSefinNacionalRTCInfoIBSCBS setCodigoIndicadorOperacao(String codigoIndicadorOperacao) {
        this.codigoIndicadorOperacao = codigoIndicadorOperacao;
        return this;
    }

    /**
     * @return Indicador sobre o destinatário dos serviços.
     */
    public NFSeSefinNacionalRTCIndicadorDestinatario getIndicadorDestinatario() {
        return indicadorDestinatario;
    }

    /**
     * @param indicadorDestinatario Indicador sobre o destinatário dos serviços.
     */
    public NFSeSefinNacionalRTCInfoIBSCBS setIndicadorDestinatario(NFSeSefinNacionalRTCIndicadorDestinatario indicadorDestinatario) {
        this.indicadorDestinatario = indicadorDestinatario;
        return this;
    }

    /**
     * @return Valores/tributos do grupo IBS/CBS.
     */
    public NFSeSefinNacionalRTCInfoValoresIBSCBS getValores() {
        return valores;
    }

    /**
     * @param valores Valores/tributos do grupo IBS/CBS.
     */
    public NFSeSefinNacionalRTCInfoIBSCBS setValores(NFSeSefinNacionalRTCInfoValoresIBSCBS valores) {
        this.valores = valores;
        return this;
    }
}
