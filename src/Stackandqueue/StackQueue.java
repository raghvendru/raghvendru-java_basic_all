package Stackandqueue;
import java.util.*;
class StackQueue {
    private Stack<Integer> st1, st2;
    public StackQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    public void push(int x) {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        st1.push(x);
        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
    }
    // Method to pop element from the queue
    public int pop() {
        // Edge case
        if (st1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // Representing empty stack
        }
        // Get the top element
        int topElement = st1.pop(); // Perform the pop operation
        return topElement; // Return the popped value
    }
    // Method to get the front element from the queue
    public int peek() {
        // Edge case
        if (st1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // Representing empty stack
        }
        // Return the top element
        return st1.peek();
    }
    // Method to find whether the queue is empty
    public boolean isEmpty() {
        return st1.isEmpty();
    }
    public static void main(String[] args) {
        StackQueue q = new StackQueue();

        // List of commands
        String[] commands = {"StackQueue", "push", "push",
                "pop", "peek", "isEmpty"};
        // List of inputs
        int[][] inputs = {{}, {4}, {8}, {}, {}, {}};

        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("push")) {
                q.push(inputs[i][0]);
                System.out.print("null ");
            } else if (commands[i].equals("pop")) {
                System.out.print(q.pop() + " ");
            } else if (commands[i].equals("peek")) {
                System.out.print(q.peek() + " ");
            } else if (commands[i].equals("isEmpty")) {
                System.out.print((q.isEmpty() ? "true" : "false") + " ");
            } else if (commands[i].equals("StackQueue")) {
                System.out.print("null ");
            }
        }
    }
}