package com.gdavidben.javalab.hexagonal;

import com.gdavidben.javalab.hexagonal.adapters.in.CardInvoiceHttpHandler;
import com.gdavidben.javalab.hexagonal.domain.CurrencyClient;
import com.gdavidben.javalab.hexagonal.adapters.out.CurrencyClientInMemory;
import com.gdavidben.javalab.hexagonal.domain.TransactionRepository;
import com.gdavidben.javalab.hexagonal.adapters.out.TransactionRepositoryInMemory;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Currency;
import java.util.Locale;

public class Main {

    private static final int PORT = 8080;
    private static final String DEFAULT_CURRENCY = Currency.getInstance(Locale.FRANCE).getCurrencyCode();
    private static final StableValue<CurrencyClient> CURRENCY_API = StableValue.of();
    private static final StableValue<TransactionRepository> TRANSACTION_REPOSITORY = StableValue.of();

    private static CurrencyClient currencyApi() {
        return CURRENCY_API.orElseSet(CurrencyClientInMemory::new);
    }

    private static TransactionRepository transactionRepository() {
        return TRANSACTION_REPOSITORY.orElseSet(TransactionRepositoryInMemory::new);
    }

    private Main() {
    }

    static void main() throws IOException {
        final HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);

        httpServer.createContext("/api/cards", new CardInvoiceHttpHandler(transactionRepository(), currencyApi(), DEFAULT_CURRENCY));

        IO.println("Server is running at http://localhost:" + PORT);
        httpServer.start();
    }
}
