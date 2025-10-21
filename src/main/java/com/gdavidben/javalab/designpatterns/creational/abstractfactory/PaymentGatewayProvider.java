package com.gdavidben.javalab.designpatterns.creational.abstractfactory;

import com.gdavidben.javalab.designpatterns.creational.abstractfactory.stripe.StripeFactory;

public class PaymentGatewayProvider {

    private PaymentGatewayProvider() {
    }

    public static PaymentGatewayFactory getFactory(final PaymentGatewayType type) {
        return switch (type) {
            case STRIPE -> new StripeFactory();
            case PAYPAL -> throw new IllegalArgumentException("Not implemented");
        };
    }
}
