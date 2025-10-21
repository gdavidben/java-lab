package com.gdavidben.javalab.hexagonal.application.usecases;

import com.gdavidben.javalab.hexagonal.domain.Currency;
import com.gdavidben.javalab.hexagonal.domain.CurrencyClient;
import com.gdavidben.javalab.hexagonal.domain.TransactionRepository;
import com.gdavidben.javalab.hexagonal.domain.Transaction;

import java.time.LocalDate;

public class CalculateInvoice {

    private final String currency;

    private final CurrencyClient currencyClient;

    private final TransactionRepository transactionRepository;


    public CalculateInvoice(final TransactionRepository transactionRepository, final CurrencyClient currencyClient, final String currency) {
        this.currency = currency;
        this.currencyClient = currencyClient;
        this.transactionRepository = transactionRepository;
    }

    public long execute(final String cardNumber) {
        final var today = LocalDate.now();
        final var month = today.getMonth().getValue();
        final var year = today.getYear();
        final var currencyPrice = currencyClient.getCurrencies(currency);

        return transactionRepository.getTransactions(cardNumber, month, year)
                                    .stream()
                                    .mapToLong(transaction -> sum(transaction, currencyPrice))
                                    .sum();
    }

    private long sum(final Transaction transaction, final Currency currency) {
        final long currencyPrice = switch (transaction.currency()) {
            case "BRL" -> currency.brl();
            case "EUR" -> currency.eur();
            case "USD" -> currency.usd();
            case null, default -> throw new IllegalStateException("Unexpected currency: " + transaction.currency());
        };

        return transaction.amount() * 100 / currencyPrice;
    }
}
