import java.util.Stack;

class MyQueue {

    Stack<Integer> input;
    Stack<Integer> output;

    // Constructor
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    // Push element to back of queue
    public void push(int x) {
        input.push(x);
    }

    // Remove and return front element
    public int pop() {
        peek(); // Ensure output has elements
        return output.pop();
    }

    // Get front element
    public int peek() {
        if (output.isEmpty()) {
            // Transfer all elements from input to output
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    // Check if queue is empty
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}