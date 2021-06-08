package com.DataStructure;

public class Stacks {
    private final int[] stack;
    private int top;
    private final int size;

    public Stacks() {
        top = -1;
        size = 50;
        stack = new int[50];
    }

    public Stacks(int size) {
        top = -1;
        this.size = size;
        stack = new int[size];
    }

    public boolean push(int item) {
        if (!isFull()) {
            top++;
            stack[top] = item;
            return true;
        } else
            return false;
    }

    public int pop() {
        return stack[top--];
    }

    public boolean isFull() {
        return (top == stack.length - 1);
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
