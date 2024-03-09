package com.designPattern.factory;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        ShapeFactory sp = new ShapeFactory();
        while (true) {
            Scanner scn = new Scanner(System.in);
            String shapeType = scn.next();
            Shape shape = sp.create(shapeType);
            shape.printShape();
        }
    }
}
