package com.fincatto.documentofiscal.nfse.utils;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalPedRegEvt;
import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalInfPedReg;
import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalInfPedRegEventoTE;

public abstract class NFSeEventoUtils {

    /**
     * Gera o Id do pedido de registro de evento conforme o layout 1.01 (TSIdPedRegEvt):
     * "PRE" + chave de acesso da NFS-e (50) + tipo do evento (6). O número do pedido de registro
     * (nPedRegEvento) não entra: ele não existe no TCInfPedReg do 1.01, e o pattern do tipo aceita
     * exatamente 56 dígitos após o "PRE".
     */
    public static String gerarId(NFSeSefinNacionalPedRegEvt evento) {

        assert evento != null : "Evento deve estar preenchido para gerar o ID";
        final NFSeSefinNacionalInfPedReg infPedReg = evento.getInfPedReg();
        assert infPedReg != null : "InfPedReg deve estar preenchido para gerar o ID";
        final String chaveAcessoNFSE = infPedReg.getChaveAcessoNFSE();
        assert chaveAcessoNFSE != null : "Chave de Acesso da NFSe deve estar preenchida para gerar o ID";
        final NFSeSefinNacionalInfPedRegEventoTE eventoInfo = infPedReg.getEvento();
        assert eventoInfo != null : "Informações do Evento devem estar preenchidas para gerar o ID";
        final String codigoEvento = eventoInfo.getCodigoEvento();
        assert codigoEvento != null : "Código do Evento deve estar preenchido para gerar o ID";
        return String.format("PRE%s%s", chaveAcessoNFSE, codigoEvento);
    }
}
