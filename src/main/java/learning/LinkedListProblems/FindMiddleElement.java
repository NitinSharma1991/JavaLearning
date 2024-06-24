package learning.LinkedListProblems;

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

    public void insertAt(String data, int x) {

        int start = 1;

        Node node = head;

        while (start < x - 1) {
            start++;
            node = node.getNode();
        }
        Node node1 = new Node();
        node1.setVal(data);
        Node node2 = node.getNode();
        node1.setNode(node2);
        node.setNode(node1);

    }

    public int length(Node node) {

        int length = 0;
        while (node.getNode() != null) {
            length++;
            node = node.getNode();
        }
        length++;
        return length;
    }

    public String dataAt(int index) throws Exception {
        Node node = head;
        int length = 0;
        if (length == index) return node.getVal();
        while (node.getNode() != null) {
            length++;
            node = node.getNode();

            if (length == index) return node.getVal();
        }

        throw new Exception();
    }

    public Node reverse(Node pointer) {
        Node current = null;
        Node previous = null;

        while (pointer.getNode() != null) {
            current = pointer;
            pointer = pointer.getNode();
            current.setNode(previous);
            previous = current;
        }
        current = pointer;
        current.node = previous;
        pointer = current;
        return pointer;
    }

    public String getLastNode(int n) {
        Node fast = head;
        Node slow = head;
        int start = 1;
        while (fast.getNode() != null) {
            fast = fast.getNode();
            start++;
            if (start > n) {
                slow = slow.getNode();
            }
        }
        return slow.getVal();
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
