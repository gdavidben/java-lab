package com.gdavidben.javalab.designpatterns.creational.abstractfactory.stripe;

import com.gdavidben.javalab.designpatterns.creational.abstractfactory.Refund;

public class StripeRefund implements Refund {

    @Override
    public void refund(String transactionId) {
        IO.println("Refunding via Stripe for transaction: " + transactionId);
    }
}
