package com.sapient.adapter;

public class CoffeeClient {

    public static void main(String[] args) {
        ICoffeeMaker coffeeMaker = new PremiumCoffeeAdapter(new PremiumCoffeeMaker());
        coffeeMaker.brewCoffee("type1");
    }
}
