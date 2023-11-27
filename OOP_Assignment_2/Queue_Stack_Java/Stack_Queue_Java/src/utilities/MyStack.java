package utilities;

public class MyStack<E> {
    private E[] data;
    private int capacity;
    private int size;

    public MyStack(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public MyStack() {
        this.capacity = 10000;
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(E element) {
        data[size] = element;
        size++;
    }

    public E peek() {
        // because array starts at 0
        return data[size - 1];
    }

    public int pop() {
        E poppedElement = data[size - 1];
        data[--size] = null;
        return (int) poppedElement;
    }

}
