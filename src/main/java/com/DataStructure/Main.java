package com.DataStructure;

public class Main {

    public static void main(String[] args) {
        Stacks stacks = new Stacks();
        if (!stacks.isFull()) {
            stacks.push(2);
            stacks.push(4);
            stacks.push(5);
            stacks.push(6);
            stacks.push(7);
            stacks.push(8);
            stacks.push(9);
        }
      while (!stacks.isEmpty())
        System.out.println(stacks.pop());

    }
}
