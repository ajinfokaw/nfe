package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

/**
 * Codigo de Situacao Tributaria do PIS/COFINS (TSTipoCST do layout da NFS-e).
 *
 * Tabela PROPRIA da NFS-e: repete 01..99 da NF-e e acrescenta o "00 - Nenhum", usado quando nao ha
 * situacao de PIS/COFINS a declarar no grupo de tributos federais da DPS.
 */
public enum NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria {

    CST_00("00", "Nenhum"),
    CST_01("01", "Opera\u00e7\u00e3o Tribut\u00e1vel com Al\u00edquota B\u00e1sica"),
    CST_02("02", "Opera\u00e7\u00e3o Tribut\u00e1vel com Al\u00edquota Diferenciada"),
    CST_03("03", "Opera\u00e7\u00e3o Tribut\u00e1vel com Al\u00edquota por Unidade de Medida de Produto"),
    CST_04("04", "Opera\u00e7\u00e3o Tribut\u00e1vel monof\u00e1sica - Revenda a Al\u00edquota Zero"),
    CST_05("05", "Opera\u00e7\u00e3o Tribut\u00e1vel por Substitui\u00e7\u00e3o Tribut\u00e1ria"),
    CST_06("06", "Opera\u00e7\u00e3o Tribut\u00e1vel a Al\u00edquota Zero"),
    CST_07("07", "Opera\u00e7\u00e3o Isenta da Contribui\u00e7\u00e3o"),
    CST_08("08", "Opera\u00e7\u00e3o sem Incid\u00eancia da Contribui\u00e7\u00e3o"),
    CST_09("09", "Opera\u00e7\u00e3o com Suspens\u00e3o da Contribui\u00e7\u00e3o"),
    CST_49("49", "Outras Opera\u00e7\u00f5es de Sa\u00edda"),
    CST_50("50", "Opera\u00e7\u00e3o com Direito a Cr\u00e9dito \u2013 Vinculada Exclusivamente a Receita Tributada no Mercado Interno"),
    CST_51("51", "Opera\u00e7\u00e3o com Direito a Cr\u00e9dito \u2013 Vinculada Exclusivamente a Receita N\u00e3o-Tributada no Mercado Interno"),
    CST_52("52", "Opera\u00e7\u00e3o com Direito a Cr\u00e9dito \u2013 Vinculada Exclusivamente a Receita de Exporta\u00e7\u00e3o"),
    CST_53("53", "Opera\u00e7\u00e3o com Direito a Cr\u00e9dito \u2013 Vinculada a Receitas Tributadas e N\u00e3o-Tributadas no Mercado Interno"),
    CST_54("54", "Opera\u00e7\u00e3o com Direito a Cr\u00e9dito \u2013 Vinculada a Receitas Tributadas no Mercado Interno e de Exporta\u00e7\u00e3o"),
    CST_55("55", "Opera\u00e7\u00e3o com Direito a Cr\u00e9dito \u2013 Vinculada a Receitas N\u00e3o Tributadas no Mercado Interno e de Exporta\u00e7\u00e3o"),
    CST_56("56", "Opera\u00e7\u00e3o com Direito a Cr\u00e9dito \u2013 Vinculada a Receitas Tributadas e N\u00e3o-Tributadas no Mercado Interno e de Exporta\u00e7\u00e3o"),
    CST_60("60", "Cr\u00e9dito Presumido \u2013 Opera\u00e7\u00e3o de Aquisi\u00e7\u00e3o Vinculada Exclusivamente a Receita Tributada no Mercado Interno"),
    CST_61("61", "Cr\u00e9dito Presumido \u2013 Opera\u00e7\u00e3o de Aquisi\u00e7\u00e3o Vinculada Exclusivamente a Receita N\u00e3o-Tributada no Mercado Interno"),
    CST_62("62", "Cr\u00e9dito Presumido \u2013 Opera\u00e7\u00e3o de Aquisi\u00e7\u00e3o Vinculada Exclusivamente a Receita de Exporta\u00e7\u00e3o"),
    CST_63("63", "Cr\u00e9dito Presumido \u2013 Opera\u00e7\u00e3o de Aquisi\u00e7\u00e3o Vinculada a Receitas Tributadas e N\u00e3o-Tributadas no Mercado Interno"),
    CST_64("64", "Cr\u00e9dito Presumido \u2013 Opera\u00e7\u00e3o de Aquisi\u00e7\u00e3o Vinculada a Receitas Tributadas no Mercado Interno e de Exporta\u00e7\u00e3o"),
    CST_65("65", "Cr\u00e9dito Presumido \u2013 Opera\u00e7\u00e3o de Aquisi\u00e7\u00e3o Vinculada a Receitas N\u00e3o-Tributadas no Mercado Interno e de Exporta\u00e7\u00e3o"),
    CST_66("66", "Cr\u00e9dito Presumido \u2013 Opera\u00e7\u00e3o de Aquisi\u00e7\u00e3o Vinculada a Receitas Tributadas e N\u00e3o-Tributadas no Mercado Interno e de Exporta\u00e7\u00e3o"),
    CST_67("67", "Cr\u00e9dito Presumido \u2013 Outras Opera\u00e7\u00f5es"),
    CST_70("70", "Opera\u00e7\u00e3o de Aquisi\u00e7\u00e3o sem Direito a Cr\u00e9dito"),
    CST_71("71", "Opera\u00e7\u00e3o de Aquisi\u00e7\u00e3o com Isen\u00e7\u00e3o"),
    CST_72("72", "Opera\u00e7\u00e3o de Aquisi\u00e7\u00e3o com Suspens\u00e3o"),
    CST_73("73", "Opera\u00e7\u00e3o de Aquisi\u00e7\u00e3o a Al\u00edquota Zero"),
    CST_74("74", "Opera\u00e7\u00e3o de Aquisi\u00e7\u00e3o sem Incid\u00eancia da Contribui\u00e7\u00e3o"),
    CST_75("75", "Opera\u00e7\u00e3o de Aquisi\u00e7\u00e3o por Substitui\u00e7\u00e3o Tribut\u00e1ria"),
    CST_98("98", "Outras Opera\u00e7\u00f5es de Entrada"),
    CST_99("99", "Outras Opera\u00e7\u00f5es");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria valor : values()) {
            if (valor.getCodigo().equals(codigo)) {
                return valor;
            }
        }
        return null;
    }
}