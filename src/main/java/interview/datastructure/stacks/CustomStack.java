package interview.datastructure.stacks;

public class CustomStack {
    public static void main(String[] args) {
        MyStack stack = new MyStack(4);

        stack.add(9);
        stack.add(10);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.add(11);
        stack.add(13);
        stack.add(12);
        System.out.println(stack.pop());
    }
}
