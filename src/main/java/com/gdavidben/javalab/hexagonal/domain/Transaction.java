package com.gdavidben.javalab.hexagonal.domain;

import java.time.LocalDateTime;

public record Transaction(String cardNumber, String description, long amount, String currency, LocalDateTime date) {
}
