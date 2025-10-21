package com.gdavidben.javalab.designpatterns.behavioral.chainofresponsability;

public class LocationCheck extends FraudCheck {

    @Override
    public boolean check(Transaction transaction) {
        if (!transaction.location().equals(transaction.userLocation())) {
            IO.println("Red flag: Unusual location.");
            return false;
        }
        return next == null || next.check(transaction);
    }
}
