package com.fincatto.documentofiscal.nfse.transformers;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalRTCIndicadorUsoConsumoPessoal;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalRTCIndicadorUsoConsumoPessoalTransformer implements Transform<NFSeSefinNacionalRTCIndicadorUsoConsumoPessoal> {
    @Override
    public NFSeSefinNacionalRTCIndicadorUsoConsumoPessoal read(String value) {
        return NFSeSefinNacionalRTCIndicadorUsoConsumoPessoal.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalRTCIndicadorUsoConsumoPessoal value) {
        return value.getCodigo();
    }
}
