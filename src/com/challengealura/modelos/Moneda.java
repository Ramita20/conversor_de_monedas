package com.challengealura.modelos;

import java.util.Map;

public class Moneda {
    String codigoMoneda;
    Map<String, Double> ratiosDeConversion;

    public Moneda(MonedaExchangeRate monedaER) {
        this.codigoMoneda = monedaER.base_code();
        this.ratiosDeConversion = monedaER.conversion_rates();
    }

    public String getCodigoMoneda() {
        return codigoMoneda;
    }

    public double convertir(double monto, String codigoMonedaAConvertir) {
        double montoConvertido = monto * this.ratiosDeConversion.get(codigoMonedaAConvertir);
        return Math.round(montoConvertido * 100.0) / 100.0;
    }
}
