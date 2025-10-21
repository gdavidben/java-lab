package com.gdavidben.javalab.designpatterns.structural.decorator;

public class CoffeeDecorator implements Coffee {

    protected Coffee decoratedCoffee;

    protected CoffeeDecorator(final Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public int cost() {
        return decoratedCoffee.cost();
    }
}
