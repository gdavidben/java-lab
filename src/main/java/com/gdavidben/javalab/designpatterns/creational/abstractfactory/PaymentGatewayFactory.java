package com.gdavidben.javalab.designpatterns.creational.abstractfactory;

public interface PaymentGatewayFactory {

    Payment createPayment();

    Refund createRefund();
}
