package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

/**
 * Relacao entre tomador/adquirente e destinatario dos servicos.
 * <p>Elemento {@code indDest} do grupo IBSCBS.</p>
 */
public enum NFSeSefinNacionalRTCIndicadorDestinatario {

    TOMADOR_E_DESTINATARIO("0", "Destinatario e o proprio tomador/adquirente"),
    DESTINATARIO_DIVERSO("1", "Destinatario diferente do adquirente");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalRTCIndicadorDestinatario(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalRTCIndicadorDestinatario valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalRTCIndicadorDestinatario valor : NFSeSefinNacionalRTCIndicadorDestinatario.values()) {
            if (valor.getCodigo().equals(codigo)) {
                return valor;
            }
        }
        return null;
    }
}
