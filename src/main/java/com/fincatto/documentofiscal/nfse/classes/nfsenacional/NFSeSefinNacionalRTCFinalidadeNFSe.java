package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

/**
 * Indicador da finalidade da emissao da NFS-e (RTC).
 * <p>Elemento {@code finNFSe} do grupo IBSCBS.</p>
 */
public enum NFSeSefinNacionalRTCFinalidadeNFSe {

    REGULAR("0", "NFS-e regular");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalRTCFinalidadeNFSe(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalRTCFinalidadeNFSe valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalRTCFinalidadeNFSe valor : NFSeSefinNacionalRTCFinalidadeNFSe.values()) {
            if (valor.getCodigo().equals(codigo)) {
                return valor;
            }
        }
        return null;
    }
}
