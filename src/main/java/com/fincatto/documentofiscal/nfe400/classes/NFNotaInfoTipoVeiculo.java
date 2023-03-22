package com.fincatto.documentofiscal.nfe400.classes;

public enum NFNotaInfoTipoVeiculo {

    AUTOMOVEL("06", "Autom\u00f3vel"),
    CAMINHAO("14", "Caminh\u00e3o"),
    CAMINHONETA("13", "Caminhoneta"),
    CARGA_CAM("24", "Carga"),
    CICLOMOTO("02", "Ciclomotor"),
    ESP_ONIBUS("22", "Especial \u00d4nibus"),
    MICROONIBUS("07", "Micro\u00f4nibus"),
    MISTO_CAM("23", "Misto"),
    MOTOCICLO("4", "Motociclo"),
    MOTONETA("03", "Motoneta"),
    ONIBUS("08", "\u00d4nibus"),
    REBOQUE("10", "Reboque"),
    SEMIRREBOQUE("11", "Semirreboque"),
    CAMINHONETA("13", "Caminhoneta"),
    CAMINHAO("14", "Caminh\u00e3o"),
    TRATOR("17", "Trator"),
    TRATOR_RODAS("18","Trator rodas"),
    TRATOR_ESTEIRAS("19","Trator esteiras"),
    TRATOR_MISTO("20","Trator misto"),
    QUADRICICLO("21","Quadriciclo"),
    ESP_ONIBUS("22", "Especial \u00d4nibus"),
    CARGA_CAM("24", "Carga"),
    MISTO_CAM("23", "Misto"),
    UTILITARIO("25","Utilit\u00e1rio"),
    MOTOR_CASA("26","Motor Casa");

    private final String codigo;
    private final String descricao;

    NFNotaInfoTipoVeiculo(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoTipoVeiculo valueOfCodigo(final String codigo) {
        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        final int codigoAsInt = Integer.parseInt(codigo);
        for (final NFNotaInfoTipoVeiculo tipoVeiculo : NFNotaInfoTipoVeiculo.values()) {
            if (Integer.parseInt(tipoVeiculo.getCodigo()) == codigoAsInt) {
                return tipoVeiculo;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}