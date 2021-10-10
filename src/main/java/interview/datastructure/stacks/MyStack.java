package interview.datastructure.stacks;

public class MyStack {

    int[] a;
    int size;
    int curr;

    public MyStack(int size) {
        this.a = new int[size];
        this.size = size;
        curr = size - 1;
    }

    public void add(int v) {
        if (!isEmpty())
            a[curr--] = v;
        else
            throw new RuntimeException("Stack is full");
    }

    public boolean isEmpty() {
        return curr < 0;
    }

    public int pop() {
            return a[curr++ + 1];

    }

    public int peek() {
        if (!isEmpty())
            return a[curr + 1];
        throw new RuntimeException("Stack is empty");
    }
}
