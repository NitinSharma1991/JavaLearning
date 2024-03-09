package com.designPattern.decorator;

public class VeggieDecorator extends PizzaDecorator {

    BasePizza basePizza;

    VeggieDecorator(BasePizza pizza) {
        this.basePizza = pizza;
    }

    @Override
    public int basePizzaCost() {
        return basePizza.basePizzaCost() + 50;
    }
}
