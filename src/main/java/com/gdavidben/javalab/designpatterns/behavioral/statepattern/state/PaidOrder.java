package com.gdavidben.javalab.designpatterns.behavioral.statepattern.state;

import com.gdavidben.javalab.designpatterns.behavioral.statepattern.Order;
import com.gdavidben.javalab.designpatterns.behavioral.statepattern.OrderState;

public class PaidOrder implements OrderState {

    @Override
    public void pay(Order order) {

    }

    @Override
    public void ship(Order order) {
        IO.println("Order shipped.");
        order.setState(new ShippedOrder());
    }

    @Override
    public void deliver(Order order) {

    }
}
