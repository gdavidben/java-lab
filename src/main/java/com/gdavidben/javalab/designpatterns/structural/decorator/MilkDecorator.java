package com.gdavidben.javalab.designpatterns.structural.decorator;

public class MilkDecorator implements Coffee {

    protected Coffee decoratedCoffee;

    protected MilkDecorator(final Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", milk";
    }

    @Override
    public int cost() {
        return decoratedCoffee.cost() + 50;
    }
}
