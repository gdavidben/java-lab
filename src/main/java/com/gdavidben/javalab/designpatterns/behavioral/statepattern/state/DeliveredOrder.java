package com.gdavidben.javalab.designpatterns.behavioral.statepattern.state;

import com.gdavidben.javalab.designpatterns.behavioral.statepattern.Order;
import com.gdavidben.javalab.designpatterns.behavioral.statepattern.OrderState;

public class DeliveredOrder implements OrderState {

    @Override
    public void pay(Order order) {
    }

    @Override
    public void ship(Order order) {

    }

    @Override
    public void deliver(Order order) {
    }
}
