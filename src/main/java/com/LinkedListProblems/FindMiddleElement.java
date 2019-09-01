package com.LinkedListProblems;

public class FindMiddleElement {

    private Node head;
    private Node tail;


    public Node getHead() {
        return head;
    }

    public void insertNode(String data) {
        Node node = new Node();
        node.setVal(data);
        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.getNode() != null) {
                n = n.getNode();
            }
            n.setNode(node);
        }
    }

    public void printList(Node node) {

        while (node.getNode() != null) {
            System.out.println(node.getVal());
            node = node.getNode();
        }
        System.out.println(node.getVal());
    }

    public static class Node {
        private String val;
        private Node node;

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }

        public Node getNode() {
            return node;
        }

        public void setNode(Node node) {
            this.node = node;
        }

        @Override
        public String toString() {
            return this.val;
        }
    }
}
