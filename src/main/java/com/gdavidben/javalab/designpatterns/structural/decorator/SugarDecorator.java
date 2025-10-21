package com.gdavidben.javalab.designpatterns.structural.decorator;

public class SugarDecorator implements Coffee {

    protected Coffee decoratedCoffee;

    protected SugarDecorator(final Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", sugar";
    }

    @Override
    public int cost() {
        return decoratedCoffee.cost() + 20;
    }
}
