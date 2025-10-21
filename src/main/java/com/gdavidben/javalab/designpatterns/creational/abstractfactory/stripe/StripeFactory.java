package com.gdavidben.javalab.designpatterns.creational.abstractfactory.stripe;

import com.gdavidben.javalab.designpatterns.creational.abstractfactory.Payment;
import com.gdavidben.javalab.designpatterns.creational.abstractfactory.PaymentGatewayFactory;
import com.gdavidben.javalab.designpatterns.creational.abstractfactory.Refund;

public class StripeFactory implements PaymentGatewayFactory {

    @Override
    public Payment createPayment() {
        return new StripePayment();
    }

    @Override
    public Refund createRefund() {
        return new StripeRefund();
    }
}
