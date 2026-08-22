package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Tributos do grupo IBS/CBS informados na DPS ({@code trib}), conforme TCRTCInfoTributosIBSCBS.
 */
@Root(name = "trib")
public class NFSeSefinNacionalRTCInfoTributosIBSCBS {

    @Element(name = "gIBSCBS")
    protected NFSeSefinNacionalRTCInfoTributosSitClas situacaoClassificacaoTributaria;

    public NFSeSefinNacionalRTCInfoTributosSitClas getSituacaoClassificacaoTributaria() {
        return situacaoClassificacaoTributaria;
    }

    public NFSeSefinNacionalRTCInfoTributosIBSCBS setSituacaoClassificacaoTributaria(NFSeSefinNacionalRTCInfoTributosSitClas situacaoClassificacaoTributaria) {
        this.situacaoClassificacaoTributaria = situacaoClassificacaoTributaria;
        return this;
    }
}
