package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

/**
 * Operacao de uso ou consumo pessoal (art. 57 da LC 214/2025).
 * <p>Elemento {@code indFinal} do grupo IBSCBS.</p>
 */
public enum NFSeSefinNacionalRTCIndicadorUsoConsumoPessoal {

    NAO("0", "Nao"),
    SIM("1", "Sim");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalRTCIndicadorUsoConsumoPessoal(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalRTCIndicadorUsoConsumoPessoal valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalRTCIndicadorUsoConsumoPessoal valor : NFSeSefinNacionalRTCIndicadorUsoConsumoPessoal.values()) {
            if (valor.getCodigo().equals(codigo)) {
                return valor;
            }
        }
        return null;
    }
}
