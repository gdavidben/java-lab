package com.gdavidben.javalab.designpatterns.behavioral.chainofresponsability;

public abstract class FraudCheck {

    protected FraudCheck next;

    public FraudCheck linkWith(final FraudCheck next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(Transaction transaction);
}
