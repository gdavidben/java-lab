package com.gdavidben.javalab.designpatterns.behavioral.strategy.payment;

import com.gdavidben.javalab.designpatterns.behavioral.strategy.PaymentStrategy;

public class BitcoinPayment implements PaymentStrategy {

    private final String walletAddress;

    public BitcoinPayment(final String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(long amount) {
        IO.println("Paid $" + amount + " using Bitcoin wallet: " + walletAddress);
    }
}
