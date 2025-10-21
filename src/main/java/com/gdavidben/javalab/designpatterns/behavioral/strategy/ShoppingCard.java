package com.gdavidben.javalab.designpatterns.behavioral.strategy;

public class ShoppingCard {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(final long amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set.");
        }

        paymentStrategy.pay(amount);
    }
}
