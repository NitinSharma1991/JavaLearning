package com.DataStructure;

public class LList {
    Node head = null;

    public void insert(String data) {
        Node node = new Node();
        node.data = data;

        if (head == null)
            head = node;
        else {
            Node current = head;
            while (current.getNode() != null) {
                current = current.getNode();
            }
            current.setNode(node);
        }
    }

    public void print(Node node) {
        while (node.getNode() != null) {
            System.out.println(node.getData());
            node = node.getNode();
        }
        System.out.println(node.getData());
    }

    public void insertAt(int a, String data) {
        int start = 1;

        Node node = new Node();
        node.setData(data);
        Node current = head;
        if (a == 0) {
            node.setNode(head);
            head = node;
            return;
        }
        while (current.getNode() != null) {
            if (start == a) {
                Node move = current.getNode();
                node.setNode(move);
                current.setNode(node);
                break;
            }
            start++;
            current = current.getNode();
        }
        Node move = current.getNode();
        node.setNode(move);
        current.setNode(node);
    }

    public Node reverse(Node pointer) {
        Node current;
        Node previous = null;

        while (pointer.getNode() != null) {
            current = pointer;
            pointer = pointer.getNode();
            current.node = previous;
            previous = current;
        }
        current = pointer;
        current.node = previous;
        pointer = current;
        return pointer;
    }

    static class Node {
        Node node;
        String data;

        public Node getNode() {
            return node;
        }

        public void setNode(Node node) {
            this.node = node;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}
