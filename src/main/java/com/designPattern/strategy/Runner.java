package com.designPattern.strategy;

public class Runner {

    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal bird = new Bird();
        dog.setName("Kaka");
        dog.setSound("Bark");
        bird.setName("Pigeon");
        bird.setName("Piu");
        System.out.printf("Dog: %s and name is %s %n", dog.fly(), dog.getName());
        System.out.println("Bird: " + bird.fly());
    }
}
