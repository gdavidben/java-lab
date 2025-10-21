package com.gdavidben.javalab.designpatterns.behavioral.strategy;

import com.gdavidben.javalab.designpatterns.behavioral.strategy.payment.CreditCardPayment;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void test() {
        final var paymentStrategy = new CreditCardPayment("1234-5678-9876-5432");
        final var shoppingCard = new ShoppingCard();

        shoppingCard.setPaymentStrategy(paymentStrategy);
        shoppingCard.checkout(250);
    }
}
