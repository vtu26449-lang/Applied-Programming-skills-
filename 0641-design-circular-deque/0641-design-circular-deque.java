class MyCircularDeque {
    private int[] data;     // Array to store elements
    private int front;      // Points to the front index
    private int rear;       // Points to the next insertion index at rear
    private int size;       // Current number of elements
    private int capacity;   // Maximum capacity of the deque

    // Constructor: initialize deque with size k
    public MyCircularDeque(int k) {
        data = new int[k];
        capacity = k;
        front = 0;
        rear = 0;
        size = 0;
    }

    // Adds an item at the front of Deque
    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + capacity) % capacity;
        data[front] = value;
        size++;
        return true;
    }

    // Adds an item at the rear of Deque
    public boolean insertLast(int value) {
        if (isFull()) return false;
        data[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }

    // Deletes an item from the front of Deque
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    // Deletes an item from the rear of Deque
    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }

    // Gets the front item from the deque
    public int getFront() {
        if (isEmpty()) return -1;
        return data[front];
    }

    // Gets the last item from the deque
    public int getRear() {
        if (isEmpty()) return -1;
        return data[(rear - 1 + capacity) % capacity];
    }

    // Checks whether the circular deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Checks whether the circular deque is full
    public boolean isFull() {
        return size == capacity;
    }
}

// Demonstration
public class Main {
    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);

        System.out.println(myCircularDeque.insertLast(1));  // true
        System.out.println(myCircularDeque.insertLast(2));  // true
        System.out.println(myCircularDeque.insertFront(3)); // true
        System.out.println(myCircularDeque.insertFront(4)); // false (full)
        System.out.println(myCircularDeque.getRear());      // 2
        System.out.println(myCircularDeque.isFull());       // true
        System.out.println(myCircularDeque.deleteLast());   // true
        System.out.println(myCircularDeque.insertFront(4)); // true
        System.out.println(myCircularDeque.getFront());     // 4
    }
}