package com.sapient.adapter;

public class PremiumCoffeeAdapter implements ICoffeeMaker{
    private PremiumCoffeeMaker premiumCoffeeMaker;

    public PremiumCoffeeAdapter(PremiumCoffeeMaker premiumCoffeeMaker) {
        this.premiumCoffeeMaker = premiumCoffeeMaker;
    }

    @Override
    public String brewCoffee(String type) {
        return premiumCoffeeMaker.coffee();
    }
}
