package com.DataStructure;

class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = new Node("head");
        tail = head;
    }

    public Node head() {
        return head;
    }

    public void add(Node node) {
        head.next = node;
        head = node;
    }

    public Integer getLength(Node head) {
        this.head = head;
        int length = 0;
        while (this.head.next() != null) {
            length++;
            this.head = this.head.next();
        }

        return length++;
    }

    public Node reverse(Node head) {

        Node pointer = head;
        Node current=null;
        Node previous = null;

        while (pointer.next != null) {
            current = pointer;

            pointer = pointer.next;
            current.next = previous;
            previous = current;
            head = current;
        }
        current = pointer;
        pointer = pointer.next;
        current.next = previous;
        head = current;
        return head;
    }

    public String getDataAt(Node head, int a) {

        int length = 0;
        int size = getLength(head);
        if (size < a) return null;
        if (a == length) return head.data();
        while (head.next() != null) {
            if (a == length)
                return head.data();
            length++;
            head = head.next();

        }
        if (a == size) return head.data();

        return null;
    }

    public void print(Node head) {

        while (head.next() != null) {
            System.out.println(head.data());
            head = head.next();
        }
        System.out.println(head.data());
    }

    public static class Node {
        private Node next;
        private String data;

        public Node(String data) {
            this.data = data;
        }

        public String data() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node next() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String toString() {
            return this.data;
        }
    }
}

