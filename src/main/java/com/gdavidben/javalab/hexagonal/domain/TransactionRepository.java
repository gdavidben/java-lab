package com.gdavidben.javalab.hexagonal.domain;

import java.util.List;

public interface TransactionRepository {

    List<Transaction> getTransactions(String cardNumber, int month, int year);
}
