class MyCircularQueue {
    private int[] data;   // Array to store queue elements
    private int front;    // Points to the front element
    private int rear;     // Points to the next insertion position
    private int size;     // Current number of elements
    private int capacity; // Maximum capacity of the queue

    // Constructor: initialize queue with size k
    public MyCircularQueue(int k) {
        data = new int[k];
        capacity = k;
        front = 0;
        rear = 0;
        size = 0;
    }

    // Insert an element into the circular queue
    public boolean enQueue(int value) {
        if (isFull()) return false;
        data[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }

    // Delete an element from the circular queue
    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    // Get the front item from the queue
    public int Front() {
        if (isEmpty()) return -1;
        return data[front];
    }

    // Get the last item from the queue
    public int Rear() {
        if (isEmpty()) return -1;
        return data[(rear - 1 + capacity) % capacity];
    }

    // Checks whether the circular queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Checks whether the circular queue is full
    public boolean isFull() {
        return size == capacity;
    }
}

// Demonstration
public class Main {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);

        System.out.println(myCircularQueue.enQueue(1)); // true
        System.out.println(myCircularQueue.enQueue(2)); // true
        System.out.println(myCircularQueue.enQueue(3)); // true
        System.out.println(myCircularQueue.enQueue(4)); // false (queue full)
        System.out.println(myCircularQueue.Rear());     // 3
        System.out.println(myCircularQueue.isFull());   // true
        System.out.println(myCircularQueue.deQueue());  // true
        System.out.println(myCircularQueue.enQueue(4)); // true
        System.out.println(myCircularQueue.Rear());     // 4
    }
}