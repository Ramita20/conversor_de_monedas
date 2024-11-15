package com.challengealura.modelos;

import java.util.Map;

public record MonedaExchangeRate(String base_code, Map<String, Double> conversion_rates) {
}
