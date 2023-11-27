package utilities;

import java.util.Arrays;
import java.util.Iterator;

public class MyDLL<E> implements ListADT<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;
    private MyDLLNode<E> head;
    private MyDLLNode<E> tail;

    public MyDLL() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot add null elements");
        }

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        MyDLLNode<E> newNode = new MyDLLNode<E>(toAdd);

        if (index == 0) {
            // Adding at the beginning
            newNode.setNext(head);
            if (head != null) {
                head.setPrevious(newNode);
            }
            head = newNode;

            if (tail == null) {
                tail = newNode;
            }
        } else if (index == size) {
            // Adding at the end
            newNode.setPrevious(tail);
            if (tail != null) {
                tail.setNext(newNode);
            }
            tail = newNode;

            if (head == null) {
                head = newNode;
            }
        } else {
            // Adding at a specific index
            MyDLLNode<E> current = getNodeAtIndex(index);
            newNode.setPrevious(current.getPrevious());
            newNode.setNext(current);
            current.getPrevious().setNext(newNode);
            current.setPrevious(newNode);
        }

        size++;
        return true;
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot add null elements");
        }

        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
        return true;
    }

    private void resizeArray() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot add null elements");
        }

        int newSize = size + toAdd.size();

        // Resize the array if needed
        while (newSize > elements.length) {
            resizeArray();
        }

        // Directly copy elements from toAdd to the current array
        for (int i = 0; i < toAdd.size(); i++) {
            elements[size + i] = toAdd.get(i);
        }

        size = newSize;

        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        MyDLLNode<E> current = getNodeAtIndex(index);
        return (current != null) ? current.getValue() : null;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        MyDLLNode<E> current = getNodeAtIndex(index);

        if (current.getPrevious() != null) {
            current.getPrevious().setNext(current.getNext());
        } else {
            // Removing the head
            head = current.getNext();
            if (head != null) {
                head.setPrevious(null);
            }
        }

        if (current.getNext() != null) {
            current.getNext().setPrevious(current.getPrevious());
        } else {
            // Removing the tail
            tail = current.getPrevious();
            if (tail != null) {
                tail.setNext(null);
            }
        }

        size--;
        return current.getValue();
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        if (toRemove == null) {
            throw new NullPointerException("Cannot remove null elements");
        }

        MyDLLNode<E> current = head;
        while (current != null) {
            if (toRemove.equals(current.getValue())) {
                if (current.getPrevious() != null) {
                    current.getPrevious().setNext(current.getNext());
                } else {
                    // Removing the head
                    head = current.getNext();
                    if (head != null) {
                        head.setPrevious(null);
                    }
                }

                if (current.getNext() != null) {
                    current.getNext().setPrevious(current.getPrevious());
                } else {
                    // Removing the tail
                    tail = current.getPrevious();
                    if (tail != null) {
                        tail.setNext(null);
                    }
                }

                size--;
                return current.getValue();
            }
            current = current.getNext();
        }

        return null; // Element not found
    }

    public MyDLLNode<E> getNodeAtIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        MyDLLNode<E> current = head;

        // Traverse to the specified index
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (toChange == null) {
            throw new NullPointerException("Cannot set null elements");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        MyDLLNode<E> current = getNodeAtIndex(index);
        E previousElement = current.getValue();
        current.setValue(toChange);
        return previousElement;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException("Cannot search for null elements");
        }

        MyDLLNode<E> current = head;
        while (current != null) {
            if (toFind.equals(current.getValue())) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("Destination array is null");
        }

        if (toHold.length < size) {
            // If the destination array is too small, create a new one with the same type
            toHold = (E[]) new Object[size];
        }

        MyDLLNode<E> current = head;
        int index = 0;
        while (current != null) {
            toHold[index++] = current.getValue();
            current = current.getNext();
        }

        return toHold;
    }

    @Override
    public Object[] toArray() {

        Object[] array = new Object[size];
        MyDLLNode<E> current = head;

        // Copy elements to the destination array
        for (int i = 0; i < size; i++) {
            array[i] = current.getValue();
            current = current.getNext();
        }

        return array;
    }

    @Override
    public utilities.Iterator<E> iterator() {
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

}