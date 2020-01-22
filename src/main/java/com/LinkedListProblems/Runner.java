package com.LinkedListProblems;

public class Runner {

    public static void main(String[] args) throws Exception {
        FindMiddleElement middleElement = new FindMiddleElement();

        middleElement.insertNode("kaka");
        middleElement.insertNode("kaka1");
        middleElement.insertNode("kaka2");
        middleElement.insertNode("kaka3");
        middleElement.insertNode("kaka4");
        middleElement.insertNode("kaka5");
        middleElement.insertNode("kaka6");

        middleElement.insertAt("Nitin",4);

       middleElement.printList(middleElement.getHead());

        FindMiddleElement.Node current = middleElement.getHead();
        FindMiddleElement.Node middle = middleElement.getHead();
        int length = 0;

//        System.out.println(middleElement.length(middleElement.getHead()));
//        System.out.println(middleElement.dataAt(6));

        middleElement.printList(middleElement.reverse(middle));

//        System.out.println(middleElement.getLastNode(3));

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
