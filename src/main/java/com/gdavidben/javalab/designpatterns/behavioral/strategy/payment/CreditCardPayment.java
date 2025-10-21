package com.gdavidben.javalab.designpatterns.behavioral.strategy.payment;

import com.gdavidben.javalab.designpatterns.behavioral.strategy.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {

    private final String cardNumber;

    public CreditCardPayment(final String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(long amount) {
        IO.println("Paid $" + amount + " using credit card: " + cardNumber);
    }
}
