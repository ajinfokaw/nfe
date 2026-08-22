package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import java.util.ArrayList;
import java.util.List;

/**
 * Tabela "codigo indicador de operacao" (cIndOp) do grupo IBS/CBS, baseada no art. 11 da
 * LC 214/2025 e publicada no Anexo VII da NT 004 (AnexoVII-IndOp_IBSCBS).
 *
 * Cada codigo tem tres textos no anexo, guardados separadamente porque cumprem papeis diferentes:
 * TIPO de operacao e CARACTERISTICA do fornecimento se repetem entre codigos vizinhos (050101 e
 * 050102 tem os dois identicos), e quem realmente os distingue e o LOCAL do fornecimento. Por isso
 * o rotulo curto ({@link #getDescricaoCurta()}), usado em combo, e montado a partir do local.
 */
public enum NFSeSefinNacionalRTCCodigoIndicadorOperacao {

    IND_OP_010101("010101", "Bem M\u00f3vel Material", "Presencial, com retirada no estabelecimento do fornecedor", "Estabelecimento do fornecedor como o local da entrega ou disponibiliza\u00e7\u00e3o do bem ao destinat\u00e1rio", false, true),
    IND_OP_010102("010102", "Bem M\u00f3vel Material", "Presencial, com retirada fora do estabelecimento do fornecedor", "Local da realiza\u00e7\u00e3o da opera\u00e7\u00e3o e sua retirada", false, true),
    IND_OP_010103("010103", "Bem M\u00f3vel Material", "N\u00e3o presencial, com entrega ou disponibiliza\u00e7\u00e3o em endere\u00e7o fornecido", "Endere\u00e7o do destinat\u00e1rio fornecido para entrega ou disponibiliza\u00e7\u00e3o (assim considerado o destino final indicado pelo adquirente)", false, true),
    IND_OP_010104("010104", "Bem M\u00f3vel Material", "Licita\u00e7\u00e3o promovida pelo poder p\u00fablico de bem apreendido ou abandonado ou leil\u00e3o judicial", "Local onde se encontra o bem m\u00f3vel material", true, false),
    IND_OP_010105("010105", "Bem M\u00f3vel Material", "Constata\u00e7\u00e3o de irregularidade pela falta de documenta\u00e7\u00e3o fiscal ou pelo acobertamento por documenta\u00e7\u00e3o inid\u00f4neo", "Local onde se encontra o bem m\u00f3vel material (Local da retirada)", true, false),
    IND_OP_010106("010106", "Bem M\u00f3vel Material", "Loca\u00e7\u00e3o de bem m\u00f3vel material em aquisi\u00e7\u00f5es realizadas de forma centralizada por contribuinte sujeito ao regime regular do IBS e da CBS que possui mais de um estabelecimento e que n\u00e3o estejam sujeitas a veda\u00e7\u00e3o \u00e0 apropria\u00e7\u00e3o de cr\u00e9ditos", "Local do domic\u00edlio principal do adquirente (estabelecimento matriz)", false, true),
    IND_OP_010201("010201", "Aquisi\u00e7\u00e3o de ve\u00edculo automotor terrestre, aqu\u00e1tico ou a\u00e9reo", "Entrega ou disponibiliza\u00e7\u00e3o do bem", "Domic\u00edlio principal do destinat\u00e1rio", false, false),
    IND_OP_010202("010202", "Aquisi\u00e7\u00e3o de ve\u00edculo automotor em licita\u00e7\u00e3o promovida pelo poder p\u00fablico de bem apreendido ou abandonado ou leil\u00e3o judic", "Entrega ou disponibiliza\u00e7\u00e3o do bem", "Domic\u00edlio principal do destinat\u00e1rio", false, false),
    IND_OP_020101("020101", "Opera\u00e7\u00e3o com bem im\u00f3vel, bem imaterial, inclusive direito, relacionada a bem im\u00f3vel", "Realiza\u00e7\u00e3o de opera\u00e7\u00f5es com bem im\u00f3vel, bem imaterial, inclusive direito, relacionado a bem im\u00f3vel", "Localidade do im\u00f3vel", false, true),
    IND_OP_020201("020201", "Servi\u00e7o prestado fisicamente sobre bem im\u00f3vel", "Execu\u00e7\u00e3o de servi\u00e7os diversos prestados fisicamente sobre bem im\u00f3vel", "Localidade do im\u00f3vel", false, true),
    IND_OP_020202("020202", "Servi\u00e7o prestado fisicamente sobre bem im\u00f3vel", "Execu\u00e7\u00e3o de servi\u00e7os sobre Bens Im\u00f3veis de Caracter\u00edsticas Especiais (BICE)", "Localidade do im\u00f3vel", false, true),
    IND_OP_020301("020301", "Servi\u00e7o de administra\u00e7\u00e3o e intermedia\u00e7\u00e3o de bem im\u00f3vel", "Execu\u00e7\u00e3o dos servi\u00e7os de administra\u00e7\u00e3o e intermedia\u00e7\u00e3o de bens im\u00f3veis", "Localidade do im\u00f3vel", false, true),
    IND_OP_020401("020401", "Servi\u00e7os de loca\u00e7\u00e3o, subloca\u00e7\u00e3o, arrendamento, direito de passagem ou permiss\u00e3o de uso, compartilhado ou n\u00e3o, de ferrovi", "Execu\u00e7\u00e3o de servi\u00e7os sobre Bens Im\u00f3veis de Caracter\u00edsticas Especiais (BICE)", "Localidade do im\u00f3vel", false, true),
    IND_OP_030101("030101", "Servi\u00e7o prestado fisicamente sobre a pessoa ou fru\u00eddo presencialmente por pessoa f\u00edsica", "Execu\u00e7\u00e3o de servi\u00e7os diversos exclusivamente prestados fisicamente sobre a pessoa ou integralmente fru\u00eddos presencialmente por pessoa f\u00edsica", "Estabelecimento do fornecedor como local da presta\u00e7\u00e3o", false, true),
    IND_OP_030102("030102", "Servi\u00e7o prestado fisicamente sobre a pessoa ou fru\u00eddo presencialmente por pessoa f\u00edsica", "Execu\u00e7\u00e3o de servi\u00e7os diversos exclusivamente prestados fisicamente sobre a pessoa ou integralmente fru\u00eddos presencialmente por pessoa f\u00edsica", "Local da presta\u00e7\u00e3o do servi\u00e7o diverso do estabelecimento do fornecedor", false, true),
    IND_OP_040101("040101", "Servi\u00e7o de planejamento, organiza\u00e7\u00e3o e administra\u00e7\u00e3o de feiras, exposi\u00e7\u00f5es, congressos, espet\u00e1culos, exibi\u00e7\u00f5es e cong\u00eane", "Execu\u00e7\u00e3o de servi\u00e7os de planejamento, organiza\u00e7\u00e3o e administra\u00e7\u00e3o de feiras, exposi\u00e7\u00f5es, congressos, espet\u00e1culos, exibi\u00e7\u00f5es e cong\u00eaneres", "Local do evento a que se refere o servi\u00e7o", false, true),
    IND_OP_050101("050101", "Servi\u00e7o prestado fisicamente sobre bem m\u00f3vel material", "Execu\u00e7\u00e3o de servi\u00e7os diversos prestados fisicamente sobre bem m\u00f3vel material", "Estabelecimento do fornecedor como local da presta\u00e7\u00e3o", false, true),
    IND_OP_050102("050102", "Servi\u00e7o prestado fisicamente sobre bem m\u00f3vel material", "Execu\u00e7\u00e3o de servi\u00e7os diversos prestados fisicamente sobre bem m\u00f3vel material", "Local da presta\u00e7\u00e3o do servi\u00e7o diverso do estabelecimento do fornecedor", false, true),
    IND_OP_050201("050201", "Servi\u00e7os portu\u00e1rios", "Execu\u00e7\u00e3o de servi\u00e7os portu\u00e1rios", "Local do porto como local da presta\u00e7\u00e3o", false, true),
    IND_OP_060101("060101", "Servi\u00e7o de transporte de passageiros", "Execu\u00e7\u00e3o de servi\u00e7os de transporte de passageiros", "Local de in\u00edcio do transporte", false, true),
    IND_OP_070101("070101", "Servi\u00e7o de transporte de carga", "Execu\u00e7\u00e3o de servi\u00e7o de transporte de carga", "Endere\u00e7o fornecido para entrega do bem", false, true),
    IND_OP_070102("070102", "Servi\u00e7o de transporte de carga", "Execu\u00e7\u00e3o de servi\u00e7o de transporte de carga", "Local da retirada do bem", false, true),
    IND_OP_080101("080101", "Servi\u00e7o de explora\u00e7\u00e3o de via", "Execu\u00e7\u00e3o de servi\u00e7os de explora\u00e7\u00e3o de via", "Local da presta\u00e7\u00e3o correspondente \u00e0 extens\u00e3o da via explorada, proporcionalmente ao territ\u00f3rio dos entes tributantes", false, false),
    IND_OP_090101("090101", "Servi\u00e7o de telefonia fixa e demais servi\u00e7os de comunica\u00e7\u00e3o prestados por meio de cabos, fios, fibras e meios similares", "Execu\u00e7\u00e3o de servi\u00e7os de telefonia fixa e demais servi\u00e7os de comunica\u00e7\u00e3o prestados por meio de cabos, fios, fibras e meios similares", "Local de instala\u00e7\u00e3o do terminal", false, false),
    IND_OP_090102("090102", "Servi\u00e7o de telefonia fixa e demais servi\u00e7os de comunica\u00e7\u00e3o prestados por meio de cabos, fios, fibras e meios similares", "Execu\u00e7\u00e3o de servi\u00e7os de telefonia fixa e demais servi\u00e7os de comunica\u00e7\u00e3o prestados por meio de cabos, fios, fibras e meios similares", "Local do domic\u00edlio principal do adquirente (assim considerada a matriz), nas aquisi\u00e7\u00f5es realizadas de forma centralizada por contribuinte sujeito ao r", false, false),
    IND_OP_100101("100101", "Cess\u00e3o de espa\u00e7o para presta\u00e7\u00e3o de servi\u00e7os publicit\u00e1rios, em opera\u00e7\u00f5es onerosas", "Realiza\u00e7\u00e3o de opera\u00e7\u00f5es de cess\u00e3o de espa\u00e7o para presta\u00e7\u00e3o de servi\u00e7os publicit\u00e1rios", "Local do domic\u00edlio principal do adquirente residente ou domiciliado no Pa\u00eds. Nas aquisi\u00e7\u00f5es indicadas no art. 11, \u00a74\u00ba, II, considera-se domic\u00edlio prin", false, true),
    IND_OP_100102("100102", "Cess\u00e3o de espa\u00e7o para presta\u00e7\u00e3o de servi\u00e7os publicit\u00e1rios, em opera\u00e7\u00f5es onerosas", "Realiza\u00e7\u00e3o de opera\u00e7\u00f5es de cess\u00e3o de espa\u00e7o para presta\u00e7\u00e3o de servi\u00e7os publicit\u00e1rios", "Local do domic\u00edlio principal do destinat\u00e1rio residente ou domiciliado no Pa\u00eds, caso o adquirente n\u00e3o seja residente ou domiciliado no Pa\u00eds", false, true),
    IND_OP_100201("100201", "Cess\u00e3o de espa\u00e7o para presta\u00e7\u00e3o de servi\u00e7os publicit\u00e1rios, em opera\u00e7\u00f5es n\u00e3o onerosas", "Realiza\u00e7\u00e3o de opera\u00e7\u00f5es de cess\u00e3o de espa\u00e7o para presta\u00e7\u00e3o de servi\u00e7os publicit\u00e1rios", "local do domic\u00edlio principal do destinat\u00e1rio residente ou domiciliado no Pa\u00eds", false, true),
    IND_OP_100301("100301", "Demais servi\u00e7os, em opera\u00e7\u00f5es onerosas", "Execu\u00e7\u00e3o dos demais servi\u00e7os em opera\u00e7\u00f5es n\u00e3o especificadas em outros indicadores ou, nos servi\u00e7os de que trata o inc. III do art. 11, esses sejam, ainda que parcialmente, prestados \u00e0 dist\u00e2ncia", "Local do domic\u00edlio principal do adquirente residente ou domiciliado no Pa\u00eds. Nas aquisi\u00e7\u00f5es indicadas no art. 11, \u00a74\u00ba, II, considera-se domic\u00edlio prin", false, true),
    IND_OP_100302("100302", "Demais servi\u00e7os, em opera\u00e7\u00f5es onerosas", "Execu\u00e7\u00e3o dos demais servi\u00e7os em opera\u00e7\u00f5es n\u00e3o especificadas em outros indicadores ou, nos servi\u00e7os de que trata o inc. III do art. 11, esses sejam, ainda que parcialmente, prestados \u00e0 dist\u00e2ncia", "Local do domic\u00edlio principal do destinat\u00e1rio residente ou domiciliado no Pa\u00eds, caso o adquirente n\u00e3o seja residente ou domiciliado no Pa\u00eds", false, true),
    IND_OP_100401("100401", "Demais servi\u00e7os, em opera\u00e7\u00f5es n\u00e3o onerosas", "Execu\u00e7\u00e3o dos demais servi\u00e7os em opera\u00e7\u00f5es n\u00e3o especificadas em outros indicadores ou, nos servi\u00e7os de que tratam o inc. III, estes sejam, ainda que parcialmente, prestados \u00e0 dist\u00e2ncia", "local do domic\u00edlio principal do destinat\u00e1rio residente ou domiciliado no Pa\u00eds", false, true),
    IND_OP_100501("100501", "Demais bens, em opera\u00e7\u00f5es onerosas", "Realiza\u00e7\u00e3o de demais opera\u00e7\u00f5es com bens n\u00e3o especificadas em outros indicadores", "Local do domic\u00edlio principal do adquirente residente ou domiciliado no Pa\u00eds. Nas aquisi\u00e7\u00f5es indicadas no art. 11, \u00a74\u00ba, II, considera-se domic\u00edlio prin", false, false),
    IND_OP_100502("100502", "Demais bens, em opera\u00e7\u00f5es onerosas", "Realiza\u00e7\u00e3o de demais opera\u00e7\u00f5es com bens n\u00e3o especificadas em outros indicadores", "Local do domic\u00edlio principal do destinat\u00e1rio residente ou domiciliado no Pa\u00eds, caso o adquirente n\u00e3o seja residente ou domiciliado no Pa\u00eds", false, false),
    IND_OP_100601("100601", "Demais bens, em opera\u00e7\u00f5es n\u00e3o onerosas", "Realiza\u00e7\u00e3o de demais opera\u00e7\u00f5es com bens n\u00e3o especificadas em outros indicadores", "local do domic\u00edlio principal do destinat\u00e1rio residente ou domiciliado no Pa\u00eds", false, false),
    IND_OP_110101("110101", "Opera\u00e7\u00f5es com abastecimento de \u00e1gua, g\u00e1s canalizado e energia el\u00e9trica", "Opera\u00e7\u00f5es destinadas a consumo", "Local da entrega ou disponibiliza\u00e7\u00e3o", false, false),
    IND_OP_110201("110201", "Opera\u00e7\u00f5es com abastecimento de \u00e1gua, g\u00e1s canalizado e energia el\u00e9trica", "Opera\u00e7\u00f5es que n\u00e3o envolvam efetivo consumo: a) no fornecimento de servi\u00e7os de transmiss\u00e3o de energia el\u00e9trica; e b) nas demais opera\u00e7\u00f5es, inclusive nas hip\u00f3teses de gera\u00e7\u00e3o, distribui\u00e7\u00e3o ou comercializa\u00e7\u00e3o de energia el\u00e9trica.", "Local do estabelecimento principal do adquirente (assim considerada a matriz), conforme \u00a74\u00ba do art. 11", false, false),
    IND_OP_120101("120101", "Nas aquisi\u00e7\u00f5es de energia el\u00e9trica realizadas de forma multilateral", "Disponibiliza\u00e7\u00e3o de energia el\u00e9trica", "Local do estabelecimento do agente ou de seus representados que figurem na posi\u00e7\u00e3o devedora da liquida\u00e7\u00e3o financeira apurada pela C\u00e2mara de Comerciali", false, false),
    IND_OP_130101("130101", "Opera\u00e7\u00f5es de transporte dutovi\u00e1rio de g\u00e1s natural", "Execu\u00e7\u00e3o do transporte dutovi\u00e1rio de g\u00e1s natural, na contrata\u00e7\u00e3o de capacidade de entrada de g\u00e1s natural do duto, nos termos da legisla\u00e7\u00e3o aplic\u00e1vel", "Local do estabelecimento principal do fornecedor", false, false),
    IND_OP_130201("130201", "Opera\u00e7\u00f5es de transporte dutovi\u00e1rio de g\u00e1s natural", "Execu\u00e7\u00e3o do transporte dutovi\u00e1rio de g\u00e1s natural, na contrata\u00e7\u00e3o de capacidade de sa\u00edda do g\u00e1s natural do duto", "Local do estabelecimento principal do adquirente", false, false);

    /** Tamanho maximo de cada parte no rotulo curto, para nao estourar a largura do combo. */
    private static final int LIMITE_PARTE = 55;

    private final String codigo;
    private final String tipoOperacao;
    private final String caracteristica;
    private final String localFornecimento;
    private final boolean aplicaNFe;
    private final boolean aplicaNFSe;

    NFSeSefinNacionalRTCCodigoIndicadorOperacao(final String codigo, final String tipoOperacao,
                                                final String caracteristica, final String localFornecimento,
                                                final boolean aplicaNFe, final boolean aplicaNFSe) {
        this.codigo = codigo;
        this.tipoOperacao = tipoOperacao;
        this.caracteristica = caracteristica;
        this.localFornecimento = localFornecimento;
        this.aplicaNFe = aplicaNFe;
        this.aplicaNFSe = aplicaNFSe;
    }

    public String getCodigo() {
        return codigo;
    }

    /** Tipo de operacao (coluna "Tipo de operacao" do anexo). */
    public String getTipoOperacao() {
        return tipoOperacao;
    }

    /** Caracteristica do fornecimento (coluna "Caracteristica do fornecimento"). */
    public String getCaracteristica() {
        return caracteristica;
    }

    /** Local do fornecimento a ser identificado no DF-e — e o que distingue codigos irmaos. */
    public String getLocalFornecimento() {
        return localFornecimento;
    }

    /** Texto integral: tipo, caracteristica e local. */
    public String getDescricao() {
        final StringBuilder texto = new StringBuilder(tipoOperacao);
        if (caracteristica != null && !caracteristica.isEmpty()) {
            texto.append(" - ").append(caracteristica);
        }
        if (localFornecimento != null && !localFornecimento.isEmpty()) {
            texto.append(" (local: ").append(localFornecimento).append(")");
        }
        return texto.toString();
    }

    /**
     * Rotulo para combo: tipo abreviado + LOCAL do fornecimento. O local entra inteiro sempre que
     * cabe, porque e ele que diferencia codigos de mesmo tipo/caracteristica.
     */
    public String getDescricaoCurta() {
        final String tipo = abreviar(tipoOperacao);
        if (localFornecimento == null || localFornecimento.isEmpty()) {
            return tipo;
        }
        return tipo + " - " + abreviar(localFornecimento);
    }

    private static String abreviar(final String texto) {
        if (texto == null) {
            return "";
        }
        return texto.length() > LIMITE_PARTE ? texto.substring(0, LIMITE_PARTE).trim() + "..." : texto;
    }

    public boolean isAplicaNFe() {
        return aplicaNFe;
    }

    public boolean isAplicaNFSe() {
        return aplicaNFSe;
    }

    public static NFSeSefinNacionalRTCCodigoIndicadorOperacao valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalRTCCodigoIndicadorOperacao valor : values()) {
            if (valor.getCodigo().equals(codigo)) {
                return valor;
            }
        }
        return null;
    }

    /** Codigos utilizaveis na NFS-e (coluna indNFSe do anexo). */
    public static List<NFSeSefinNacionalRTCCodigoIndicadorOperacao> valuesNFSe() {
        final List<NFSeSefinNacionalRTCCodigoIndicadorOperacao> lista = new ArrayList<NFSeSefinNacionalRTCCodigoIndicadorOperacao>();
        for (final NFSeSefinNacionalRTCCodigoIndicadorOperacao valor : values()) {
            if (valor.isAplicaNFSe()) {
                lista.add(valor);
            }
        }
        return lista;
    }

    @Override
    public String toString() {
        return codigo + " - " + getDescricaoCurta();
    }
}