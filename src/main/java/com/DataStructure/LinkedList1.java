package com.DataStructure;


public class LinkedList1 {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        LinkedList.Node head = linkedList.head();
        linkedList.add(new LinkedList.Node("1"));
        linkedList.add(new LinkedList.Node("2"));
        linkedList.add(new LinkedList.Node("3"));
        linkedList.add(new LinkedList.Node("4"));
        linkedList.add(new LinkedList.Node("5"));
        linkedList.add(new LinkedList.Node("6"));
        linkedList.add(new LinkedList.Node("7"));

        //finding middle element of LinkedList in single pass
        LinkedList.Node current = head;
        int length = 0;
        LinkedList.Node middle = head;

        while (current.next() != null) {
            length++;
            if (length % 2 == 0) {
                middle = middle.next();
            }
            current = current.next();
        }

        if (length % 2 == 1) {
            middle = middle.next();
        }

        System.out.println("length of LinkedList: " + linkedList.getLength(head));
        System.out.println("middle element of LinkedList : " + middle);
        System.out.println("Node from head " + linkedList.getDataAt(head, 3));
        LinkedList.Node node = linkedList.reverse(head);
        System.out.println("Node from tail " + linkedList.getDataAt(node, 1));
        linkedList.print(node);

    }


}
