package com.gdavidben.javalab.designpatterns.creational.abstractfactory.stripe;

import com.gdavidben.javalab.designpatterns.creational.abstractfactory.Payment;

public class StripePayment implements Payment {
    @Override
    public void process(long amount) {
        IO.println("Processing Stripe payment of $: " + amount);
    }
}
