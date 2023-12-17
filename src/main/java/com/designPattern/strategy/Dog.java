package com.designPattern.strategy;

public class Dog extends Animal{

    Dog(){
        fly = new CantFly();
    }
}
