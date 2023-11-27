package utilities;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements ListADT<E>, utilities.Iterator<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
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

        if (size == DEFAULT_CAPACITY) {
            throw new IndexOutOfBoundsException("List is full");
        }

        // Shift elements to the right to make space for the new element
        for (int i = size - 1; i > index; i--) {
            elements[i + 1] = elements[i];
        }

        // Insert the new element
        elements[index] = toAdd;
        size++;
        return true;
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot add null elements");
        }

        if (size == DEFAULT_CAPACITY) {
            throw new IndexOutOfBoundsException("List is full");
        }

        elements[size++] = toAdd;
        return true;
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
        int currentIndex = size;
        for (int i = 0; i < toAdd.size(); i++) {
            elements[currentIndex++] = toAdd.get(i);
        }

        size = newSize;

        return true;
    }

    // Helper method to resize the array
    private void resizeArray() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        return (E) elements[index];
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        E removedElement = (E) elements[index];

        // Shift elements to the left to fill the gap
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);

        // Set the last element to null and decrease the size
        elements[--size] = null;

        return removedElement;
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        if (toRemove == null) {
            throw new NullPointerException("Cannot remove null elements");
        }

        for (int i = 0; i < size; i++) {
            if (toRemove.equals(elements[i])) {

                E removedElement = (E) elements[i];
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                elements[--size] = null;
                return removedElement;
            }
        }

        return null;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (toChange == null) {
            throw new NullPointerException("Cannot set null elements");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        E previousElement = (E) elements[index];
        elements[index] = toChange;
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

        for (int i = 0; i < size; i++) {
            if (toFind.equals(elements[i])) {
                return true;
            }
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
            toHold = Arrays.copyOf(toHold, size);
        }

        System.arraycopy(elements, 0, toHold, 0, size);
        return toHold;
    }

    @Override
    public E[] toArray() {
        E[] result = (E[]) new Object[size];

        System.arraycopy(elements, 0, result, 0, size);

        return result;
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
    }

    @Override
    public E next() throws NoSuchElementException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'next'");
    }

    @Override
    public utilities.Iterator<E> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

}
