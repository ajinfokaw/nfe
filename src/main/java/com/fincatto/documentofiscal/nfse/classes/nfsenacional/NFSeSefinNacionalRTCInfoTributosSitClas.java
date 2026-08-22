package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Situação e classificação tributária do IBS/CBS ({@code gIBSCBS}), conforme TCRTCInfoTributosSitClas.
 */
@Root(name = "gIBSCBS")
public class NFSeSefinNacionalRTCInfoTributosSitClas {

    @Element(name = "CST")
    protected String cst;
    @Element(name = "cClassTrib")
    protected String codigoClassificacaoTributaria;
    @Element(name = "cCredPres", required = false)
    protected String codigoCreditoPresumido;

    /**
     * @return Código de Situação Tributária do IBS/CBS (3 dígitos).
     */
    public String getCST() {
        return cst;
    }

    /**
     * @param cst Código de Situação Tributária do IBS/CBS (3 dígitos).
     */
    public NFSeSefinNacionalRTCInfoTributosSitClas setCST(String cst) {
        this.cst = cst;
        return this;
    }

    /**
     * @return Código de Classificação Tributária do IBS/CBS (6 dígitos).
     */
    public String getCodigoClassificacaoTributaria() {
        return codigoClassificacaoTributaria;
    }

    /**
     * @param codigoClassificacaoTributaria Código de Classificação Tributária do IBS/CBS (6 dígitos).
     */
    public NFSeSefinNacionalRTCInfoTributosSitClas setCodigoClassificacaoTributaria(String codigoClassificacaoTributaria) {
        this.codigoClassificacaoTributaria = codigoClassificacaoTributaria;
        return this;
    }

    /**
     * @return Código de Crédito Presumido.
     */
    public String getCodigoCreditoPresumido() {
        return codigoCreditoPresumido;
    }

    /**
     * @param codigoCreditoPresumido Código de Crédito Presumido.
     */
    public NFSeSefinNacionalRTCInfoTributosSitClas setCodigoCreditoPresumido(String codigoCreditoPresumido) {
        this.codigoCreditoPresumido = codigoCreditoPresumido;
        return this;
    }
}
