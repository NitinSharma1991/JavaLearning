package com.designPattern.strategy;

public class Bird extends Animal {

    Bird() {
        super();
        fly = new ItFly();

    }
}
