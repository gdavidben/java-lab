package com.gdavidben.javalab.hexagonal.adapters.in;

import com.gdavidben.javalab.hexagonal.application.usecases.CalculateInvoice;
import com.gdavidben.javalab.hexagonal.domain.CurrencyClient;
import com.gdavidben.javalab.hexagonal.domain.TransactionRepository;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class CardInvoiceHttpHandler implements HttpHandler {

    private final CalculateInvoice calculateInvoice;

    public CardInvoiceHttpHandler(final TransactionRepository transactionRepository, final CurrencyClient currencyClient, final String currency) {
        this.calculateInvoice = new CalculateInvoice(transactionRepository, currencyClient, currency);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        final var method = exchange.getRequestMethod();
        final var path = exchange.getRequestURI().getPath();
        final var parts = path.split("/");

        if (!"GET".equalsIgnoreCase(method)) {
            exchange.sendResponseHeaders(405, -1);
            return;
        }

        if ("invoices".equals(parts[4])) {
            final var cardNumber = parts[3];
            final var total = calculateInvoice.execute(cardNumber);

            final String response = "{\"total\": " + total + "}";

            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.getBytes().length);

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        } else {
            exchange.sendResponseHeaders(404, -1);
        }
    }
}
