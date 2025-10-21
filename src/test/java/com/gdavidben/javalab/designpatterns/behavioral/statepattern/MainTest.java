package com.gdavidben.javalab.designpatterns.behavioral.statepattern;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void test() {
        final var order = new Order();

        order.pay();      // moves to Paid
        order.ship();     // moves to Shipped
        order.deliver();  // moves to Delivered
    }
}
