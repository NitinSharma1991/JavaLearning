package com.designPattern.decorator;

public class Runner {

    public static void main(String[] args) {
        BasePizza basePizza = new VeggieDecorator(new MargeritaPizza());
        BasePizza basePizza1 = new CheeseDecorator(basePizza);

        System.out.println(basePizza.basePizzaCost());
    }
}
