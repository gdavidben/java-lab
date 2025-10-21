package com.gdavidben.javalab.hexagonal.adapters.out;

import com.gdavidben.javalab.hexagonal.domain.Transaction;
import com.gdavidben.javalab.hexagonal.domain.TransactionRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class TransactionRepositoryInMemory implements TransactionRepository {

    private static final List<Transaction> TRANSACTIONS = List.of(
            new Transaction("4359231209228965", "Bottle of water", 300, "EUR", LocalDateTime.of(LocalDate.of(2025, 10, 1), LocalTime.now())),
            new Transaction("3506177410522224", "Sandwich", 500, "USD", LocalDateTime.of(LocalDate.of(2025, 10, 2), LocalTime.now())),
            new Transaction("3506177410522224", "Lunch", 3000, "USD", LocalDateTime.of(LocalDate.of(2025, 10, 3), LocalTime.now())),
            new Transaction("3506177410522224", "Cinema ticket", 8000, "BRL", LocalDateTime.of(LocalDate.of(2025, 11, 1), LocalTime.now()))
    );

    @Override
    public List<Transaction> getTransactions(String cardNumber, int month, int year) {
        return TRANSACTIONS.stream()
                           .filter(t ->
                                   cardNumber.equals(t.cardNumber()) &&
                                           month == t.date().getMonth().getValue() &&
                                           year == t.date().getYear()
                           )
                           .toList();
    }
}
