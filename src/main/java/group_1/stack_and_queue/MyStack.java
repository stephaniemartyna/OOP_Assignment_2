package group_1.stack_and_queue;

import java.util.EmptyStackException;

public class MyStack<E> implements StackADT<E> {
    private MyArrayList<E> data;

    // Constructor to initialize the MyArrayList
    public MyStack() {
        this.data = new MyArrayList<>();
    }

    // Pushes an item onto the top of this stack.
    @Override
    public void push(E toAdd) throws NullPointerException {
        // Add the element to the end of the list
        data.add(toAdd);
    }

    // Removes the object at the top of this stack and returns that object.
    @Override
    public E pop() throws EmptyStackException {
        // Check if the stack is empty
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        // Remove and return the last element in the list
        return data.remove(data.size() - 1);
    }

    // Looks at the object at the top of this stack without removing it.
    @Override
    public E peek() throws EmptyStackException {
        // Check if the stack is empty
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        // Return the last element in the list without removing it
        return data.get(data.size() - 1);
    }

    // Clears all the items from this stack.
    @Override
    public void clear() {
        // Clear the underlying list
        data.clear();
    }

    // Returns true if this Stack contains no items.
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // Returns an array containing all of the elements in this list in proper sequence.
    @Override
    public Object[] toArray() {
        return data.toArray();
    }

    // Returns an array containing all of the elements in this list in proper sequence.
    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        return data.toArray(holder);
    }

    // Returns true if this list contains the specified element.
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        return data.contains(toFind);
    }

    // Returns the 1-based position where an object is on this stack.
    @Override
    public int search(E toFind) {
        // Iterate from the top to the bottom of the stack
        for (int i = data.size() - 1; i >= 0; i--) {
            if (toFind.equals(data.get(i))) {
                // Element found, return the 1-based position
                return data.size() - i;
            }
        }

        // Element not found
        return -1;
    }

    // Returns a custom iterator over the elements in this stack in proper sequence.
    @Override
    public Iterator<E> iterator() {
        // Implement iterator using IteratorMyArrayList
        return new IteratorMyArrayList<>(data.toArray((E[]) new Object[data.size()]));
    }

    // Used to compare two Stack ADT's for equality.
    @Override
    public boolean equals(StackADT<E> that) {
        // Implement equality check using MyArrayList
        return data.equals(((MyStack<E>) that).data);
    }

    // Returns the depth of the current stack as an integer value.
    @Override
    public int size() {
        // Return the size of the underlying list
        return data.size();
    }
}
