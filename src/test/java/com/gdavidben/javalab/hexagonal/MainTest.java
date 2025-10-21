package com.gdavidben.javalab.hexagonal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpClient.newHttpClient;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @BeforeAll
    static void startServer() {

        new Thread(() -> {
            try {
                Main.main();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

        // Wait a bit for the server to be ready (not ideal, but simple)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testCalculateInvoice() throws IOException, InterruptedException {
        try (var client = newHttpClient()) {
            final var request = HttpRequest.newBuilder()
                                           .uri(URI.create("http://localhost:8080/api/cards/3506177410522224/invoices"))
                                           .GET().build();
            final var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            assertEquals(200, response.statusCode());
            assertEquals("{\"total\": 2991}", response.body());
        }
    }
}
