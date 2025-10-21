package com.gdavidben.javalab.designpatterns.creational.abstractfactory;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void test() {
        final var factory = PaymentGatewayProvider.getFactory(PaymentGatewayType.STRIPE);
        final var payment = factory.createPayment();
        final var refund = factory.createRefund();

        payment.process(100);
        refund.refund("TXN123456");
    }
}
