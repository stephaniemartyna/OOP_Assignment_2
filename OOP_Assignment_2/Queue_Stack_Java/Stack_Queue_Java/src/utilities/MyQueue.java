package utilities;

public class MyQueue {
    private int[] data;
    private int size;
    private int capacity;

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public MyQueue(int capacity) {
        this.capacity = capacity;
        data = new int[size];
        size = 0;
    }

    public MyQueue() {
        this.capacity = 10000;
        data = new int[size];
        size = 0;
    }

    public void enqueue(int element) {
        data[size++] = element;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        // because array starts at 0
        return data[0];
    }

    public void dequeue() {
        // remove first element

        for (int i = 1; i < size; i++) {
            data[i - 1] = data[i];
        }
    }

}
