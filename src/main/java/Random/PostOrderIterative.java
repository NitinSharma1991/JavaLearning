package Random;

import java.util.LinkedList;
import java.util.Stack;

public class PostOrderIterative {

    public static void main(String[] args) {

        Node r = new Node(10);
        r.left = new Node(13);
        r.right = new Node(14);
        r.left.left = new Node(12);
        r.left.left.left = new Node(1);
        r.left.left.left.left = new Node(12);
        r.right.left = new Node(123);
        LinkedList<Integer> res = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(r);

        //postOrder
        while (!stack.isEmpty()) {
            Node root = stack.pop();
            res.addFirst(root.val);
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }

        System.out.println("Post Order Traversal" + res);
        res.clear();
        stack.add(r);
        //preOrder
        while (!stack.isEmpty()) {
            Node root = stack.pop();
            res.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        System.out.println("Pre Order Traversal" + res);
        res.clear();
        Node c = r;
        //InOrder
        while (c != null || !stack.isEmpty()) {

            while (c != null) {
                stack.push(c);
                c = c.left;
            }

            Node pop = stack.pop();
            res.add(pop.val);
            if (pop.right != null)
                c = pop.right;
        }

        System.out.println("In Order Traversal" + res);
    }

    static class Node {
        Node left;
        Node right;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }
}
