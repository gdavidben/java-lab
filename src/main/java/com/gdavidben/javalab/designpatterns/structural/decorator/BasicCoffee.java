package com.gdavidben.javalab.designpatterns.structural.decorator;

public class BasicCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Basic Coffee";
    }

    @Override
    public int cost() {
        return 200;
    }
}
