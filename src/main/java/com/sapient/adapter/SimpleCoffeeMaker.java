package com.sapient.adapter;

public class SimpleCoffeeMaker implements ICoffeeMaker {

    @Override
    public String brewCoffee(String type) {
        return "Simple Coffee has been brewed";
    }
}
