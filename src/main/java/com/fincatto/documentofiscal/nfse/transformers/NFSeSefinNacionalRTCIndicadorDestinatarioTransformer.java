package com.fincatto.documentofiscal.nfse.transformers;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalRTCIndicadorDestinatario;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalRTCIndicadorDestinatarioTransformer implements Transform<NFSeSefinNacionalRTCIndicadorDestinatario> {
    @Override
    public NFSeSefinNacionalRTCIndicadorDestinatario read(String value) {
        return NFSeSefinNacionalRTCIndicadorDestinatario.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalRTCIndicadorDestinatario value) {
        return value.getCodigo();
    }
}
