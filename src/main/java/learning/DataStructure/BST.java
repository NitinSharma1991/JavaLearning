package learning.DataStructure;


public class BST {

    private Node root;

    public BST(Node root) {
        this.root = null;
    }

    public void insertData(String s) {
        root = insert(root, s);
    }

    public Node insert(Node node, String s) {

        if (node == null) {
            node = new Node();
            node.data = s;
        } else if (node.data.compareTo(s) >= 0) {
            node.left = insert(node.left, s);
        } else {
            node.right = insert(node.right, s);
        }

        return node;
    }

    public void preOrder() {

        preOrder(root);

    }

    private void preOrder(Node root) {
        if (root == null)
            return;
        System.out.println(root.getData());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    static class Node {
        private String data;
        private Node left, right;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
