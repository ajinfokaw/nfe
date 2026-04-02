package com.fincatto.documentofiscal.nfse.utils;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalPedRegEvt;
import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalInfPedReg;
import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalInfPedRegEventoTE;
import org.apache.commons.lang3.StringUtils;

public abstract class NFSeEventoUtils {
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
        final String numeroPedidoRegistroEvento = infPedReg.getNPedRegEvento();
        assert numeroPedidoRegistroEvento != null : "Número do Pedido de Registro do Evento deve estar preenchido para gerar o ID";

        return String.format("PRE%s%s%s",
                chaveAcessoNFSE,
                codigoEvento,
                StringUtils.leftPad(numeroPedidoRegistroEvento, 3, '0')
        );
    }
}
