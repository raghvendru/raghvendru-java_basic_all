package Stackandqueue;
class Node1 {
    int val;
    Node1 next;
    Node1(int d) {
        val = d;
        next = null;
    }
}
class LinkedListQueue {
    private Node1 start; // Start of the queue
    private Node1 end; // End of the queue
    private int size; // Size of the queue
    public LinkedListQueue() {
        start = end = null;
        size = 0;
    }
    public void push(int x) {
        Node1 element = new Node1(x);
        if (start == null) {
            start = end = element;
        } else {
            end.next = element; // Updating the pointers
            end = element; // Updating the end
        }
        size++;
    }
    public int pop() {
        // If the queue is empty
        if (start == null) {
            return -1; // Pop operation cannot be performed
        }
        int value = start.val; // Get the front value
        Node1 temp = start; // Store the front temporarily
        start = start.next; // Update front to next Node1
        temp = null; // Delete old front Node1
        size--; // Decrement size
        return value; // Return data
    }
    public int peek() {
        if (start == null) {
            return -1; // Front element cannot be accessed
        }
        return start.val; // Return the front
    }
    public boolean isEmpty() {
        return (size == 0);
    }
    public static void main(String[] args) {
        LinkedListQueue q = new LinkedListQueue();
        String[] commands = {"LinkedListQueue", "push", "push",
                "peek", "pop", "isEmpty"};
        int[][] inputs = {{}, {3}, {7}, {}, {}, {}};
        for (int i = 0; i < commands.length; ++i) {
            if (commands[i].equals("push")) {
                q.push(inputs[i][0]);
                System.out.print("null ");
            } else if (commands[i].equals("pop")) {
                System.out.print(q.pop() + " ");
            } else if (commands[i].equals("peek")) {
                System.out.print(q.peek() + " ");
            } else if (commands[i].equals("isEmpty")) {
                System.out.print((q.isEmpty() ? "true" : "false") + " ");
            } else if (commands[i].equals("LinkedListQueue")) {
                System.out.print("null ");
            }
        }
    }
}