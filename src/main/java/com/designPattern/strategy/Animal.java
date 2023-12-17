package com.designPattern.strategy;

public class Animal {

    public Fly fly;
    private String name;
    private String sound;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public Fly getFly() {
        return fly;
    }

    public String fly() {
        return fly.fly();
    }
}
