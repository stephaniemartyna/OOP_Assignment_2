package group_1.stack_and_queue;

public class MyArrayList<E> implements ListADT<E> {
    private static final int CAPACITY = 10;
    private E[] list;
    private int size;

    // Default constructor with a default capacity
    public MyArrayList() {
        this(CAPACITY);
    }

    // Constructor to create a MyArrayList with a specified capacity
    public MyArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be greater than 0");
        }
        list = (E[]) new Object[initialCapacity];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        // Setting all elements to null effectively clears the list
        for (int i = 0; i < size; i++) {
            list[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean add(int index, E toAdd) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        // Make sure it has space
        resizeArray(size + 1);

        // Shift elements to the right to make space for the new element
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }

        // Insert the new element
        list[index] = toAdd;
        size++;
        return true;
    }

    @Override
    public boolean add(E toAdd) {
        // Adding at the end of the list
        return add(size, toAdd);
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) {
        //  Make sure it has space
        resizeArray(size + toAdd.size());

        // Copy elements from toAdd to this list
        for (int i = 0; i < toAdd.size(); i++) {
            add(toAdd.get(i));
        }

        return true;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return list[index];
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        E removedElement = list[index];

        // Shift elements to the left to fill the gap
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }

        // Set the last element to null to free up memory
        list[size - 1] = null;
        size--;

        return removedElement;
    }

    @Override
    public E remove(E toRemove) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(toRemove)) {
                return remove(i);
            }
        }
        return null; // Element not found
    }

    @Override
    public E set(int index, E toChange) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        E replacedElement = list[index];
        list[index] = toChange;
        return replacedElement;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E toFind) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(toFind)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) {
        if (toHold.length < size) {
            // If the provided array is not big enough, create a new one
            toHold = (E[]) new Object[size];
        }

        // Copy elements to the provided array
        System.arraycopy(list, 0, toHold, 0, size);

        return toHold;
    }

    @Override
    public Object[] toArray() {
        // Create a new array of Objects and copy elements
        Object[] result = new Object[size];
        System.arraycopy(list, 0, result, 0, size);
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        // Create an iterator using IteratorMyArrayList
        return new IteratorMyArrayList<>(list);
    }

    // Ensure the internal array has sufficient capacity
    private void resizeArray(int minCapacity) {
        if (minCapacity > list.length) {
            int newCapacity = list.length * 2;
            if (newCapacity < minCapacity) {
                // If doubling is still not enough, set the new capacity to the required minCapacity
                newCapacity = minCapacity;
            }

            // Create a new array with the updated capacity
            E[] newList = (E[]) new Object[newCapacity];

            // Copy elements to the new array
            System.arraycopy(list, 0, newList, 0, size);

            // Update the reference to the new array
            list = newList;
        }
    }
}
