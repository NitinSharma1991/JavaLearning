package learning.DataStructure;

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

    public Node swapPairs(Node head) {

        if (head == null) return null;

        Node slow = head;
        Node fast = head.node;

        while (slow != null && slow.node != null) {
            Node temp = slow;
            slow = slow.node;
            temp.node = slow.node;
            slow.node = temp;
            slow = temp.node;
            if (slow != null && slow.node != null) temp.node = slow.node;
        }
        return fast;
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

    public int length(Node node) {

        if (node == null) return 0;

        int length = 1;

        while (node.getNode() != null) {
            length++;
            node = node.getNode();
        }

        return length;

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
