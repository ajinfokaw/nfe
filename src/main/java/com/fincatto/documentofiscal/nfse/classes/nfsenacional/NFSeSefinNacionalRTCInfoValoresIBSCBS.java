package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Valores do grupo IBS/CBS informados na DPS ({@code valores}), conforme TCRTCInfoValoresIBSCBS.
 */
@Root(name = "valores")
public class NFSeSefinNacionalRTCInfoValoresIBSCBS {

    @Element(name = "trib")
    protected NFSeSefinNacionalRTCInfoTributosIBSCBS tributos;

    public NFSeSefinNacionalRTCInfoTributosIBSCBS getTributos() {
        return tributos;
    }

    public NFSeSefinNacionalRTCInfoValoresIBSCBS setTributos(NFSeSefinNacionalRTCInfoTributosIBSCBS tributos) {
        this.tributos = tributos;
        return this;
    }
}
