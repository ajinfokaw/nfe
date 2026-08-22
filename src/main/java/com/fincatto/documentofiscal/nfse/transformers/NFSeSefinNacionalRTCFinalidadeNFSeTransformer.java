package com.fincatto.documentofiscal.nfse.transformers;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalRTCFinalidadeNFSe;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalRTCFinalidadeNFSeTransformer implements Transform<NFSeSefinNacionalRTCFinalidadeNFSe> {
    @Override
    public NFSeSefinNacionalRTCFinalidadeNFSe read(String value) {
        return NFSeSefinNacionalRTCFinalidadeNFSe.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalRTCFinalidadeNFSe value) {
        return value.getCodigo();
    }
}
