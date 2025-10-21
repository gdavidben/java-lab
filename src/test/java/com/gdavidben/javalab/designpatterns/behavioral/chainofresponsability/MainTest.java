package com.gdavidben.javalab.designpatterns.behavioral.chainofresponsability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @Test
    void test() {
        final var fraudCheck = new HighAmountCheck();
        fraudCheck.linkWith(new LocationCheck());

        final var transaction = new Transaction(100_00, "BR", "BR");
        final var legitim = fraudCheck.check(transaction);

        assertTrue(legitim);
    }
}
