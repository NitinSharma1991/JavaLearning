package com.designPattern.strategy;

public class Bird extends Animal {

    Bird() {
        super();
        setSound("Chew");
        fly = new ItFly();

    }
}
