package com.gdavidben.javalab.designpatterns.behavioral.statepattern;

import com.gdavidben.javalab.designpatterns.behavioral.statepattern.state.NewOrder;

public class Order {
    private OrderState state;

    public Order() {
        this.state = new NewOrder();
    }

    public void setState(final OrderState state) {
        this.state = state;
    }

    public void pay() {
        state.pay(this);
    }

    public void ship() {
        state.ship(this);
    }

    public void deliver() {
        state.deliver(this);
    }
}
