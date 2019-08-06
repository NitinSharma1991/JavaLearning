package com.LinkedListProblems;

public class Runner {

    public static void main(String[] args) {
        FindMiddleElement middleElement = new FindMiddleElement();

        middleElement.insertNode("kaka");
        middleElement.insertNode("kaka1");
        middleElement.insertNode("kaka2");
        middleElement.insertNode("kaka3");
        middleElement.insertNode("kaka4");
        middleElement.insertNode("kaka5");
        middleElement.insertNode("kaka6");

        FindMiddleElement.Node current = middleElement.getHead();
        FindMiddleElement.Node middle = middleElement.getHead();
        int length = 0;

        while (current.getNode() != null) {
            length++;
            if (length % 2 == 0) {
                middle = middle.getNode();
            }
            current = current.getNode();
        }

        if (length % 2 == 1) {
            middle = middle.getNode();
        }

        System.out.println("middle element of LinkedList : " + middle);
//        middleElement.printList(middleElement.getHead());
    }
}
