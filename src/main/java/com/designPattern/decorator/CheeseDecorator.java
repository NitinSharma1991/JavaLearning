package com.designPattern.decorator;

public class CheeseDecorator extends PizzaDecorator {

    BasePizza basePizza;

    CheeseDecorator(BasePizza pizza) {
        this.basePizza = pizza;
    }
    @Override
    public int basePizzaCost() {
        return basePizza.basePizzaCost() + 50;
    }
}
