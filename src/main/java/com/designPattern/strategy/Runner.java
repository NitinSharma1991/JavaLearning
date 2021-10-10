package com.designPattern.strategy;

public class Runner {

    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal bird = new Bird();
        System.out.println("Dog: " + dog.getFly());
        System.out.println("Bird: " + bird.getFly());

        dog.setFly(new ItFly());
        System.out.println("Dog: " + dog.getFly());



    }




}
