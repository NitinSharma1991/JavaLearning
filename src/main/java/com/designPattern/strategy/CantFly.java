package com.designPattern.strategy;

public class CantFly implements Fly {
    @Override
    public String fly() {
        return "Can't Fly";
    }
}
