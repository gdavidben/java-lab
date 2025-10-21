package com.gdavidben.javalab.designpatterns.behavioral.chainofresponsability;

public class HighAmountCheck extends FraudCheck {

    @Override
    public boolean check(Transaction transaction) {
        if (transaction.amount() > 100_000_00) {
            IO.println("Red flag: High amount.");
            return false;
        }
        return next == null || next.check(transaction);
    }
}
