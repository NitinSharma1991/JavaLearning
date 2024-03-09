package com.designPattern.strategy;

public class SportsDrive implements DriveStrategy{
    @Override
    public String drive() {
        return "This is a sport drive";
    }
}
