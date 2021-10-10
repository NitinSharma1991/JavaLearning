package com.designPattern.strategy;

public class Dog extends Animal{

    Dog(){
        setSound("Bark");
        fly = new CantFly();
    }
}
