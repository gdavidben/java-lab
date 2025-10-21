package com.gdavidben.javalab.hexagonal.adapters.out;

import com.gdavidben.javalab.hexagonal.domain.Currency;
import com.gdavidben.javalab.hexagonal.domain.CurrencyClient;

public class CurrencyClientInMemory implements CurrencyClient {

    @Override
    public Currency getCurrencies(final String currency) {
        return switch (currency) {
            case "BRL" -> new Currency(100, 626, 537);
            case "EUR" -> new Currency(626, 100, 117);
            case "USD" -> new Currency(19, 86, 100);
            case null, default -> throw new IllegalArgumentException("Not supported");
        };
    }
}
