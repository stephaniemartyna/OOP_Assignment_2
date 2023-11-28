package group_1.stack_and_queue;

public class MyDLL<E> implements ListADT<E> {
    private MyDLLNode<E> head;
    private MyDLLNode<E> tail;
    private int size;

    public MyDLL() {
        this.head = null;
        this.tail = null;
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
            throw new NullPointerException("Cannot add null element");
        }

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);

        if (index == 0) {
            // Adding at the beginning
            newNode.setNext(head);
            if (head != null) {
                head.setPrevious(newNode);
            }
            head = newNode;

            if (tail == null) {
                // The list was empty
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
                // The list was empty
                head = newNode;
            }
        } else {
            // Adding at a specific index
            MyDLLNode<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }

            MyDLLNode<E> previous = current.getPrevious();
            newNode.setNext(current);
            newNode.setPrevious(previous);
            current.setPrevious(newNode);

            if (previous != null) {
                previous.setNext(newNode);
            } else {
                // Adding at the beginning
                head = newNode;
            }
        }

        size++;
        return true;
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException {
        // Adding at the end
        return add(size, toAdd);
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        // Create an iterator for the provided list
        Iterator<? extends E> iterator = toAdd.iterator();

        // Iterate over each element in the provided list
        while (iterator.hasNext()) {
            // Add the current element to the end of this list
            add(iterator.next());
        }
        // Return true to indicate the operation was successful
        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        MyDLLNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getValue();
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        MyDLLNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        MyDLLNode<E> previous = current.getPrevious();
        MyDLLNode<E> next = current.getNext();

        if (previous != null) {
            previous.setNext(next);
        } else {
            // Removing the first element
            head = next;
        }

        if (next != null) {
            next.setPrevious(previous);
        } else {
            // Removing the last element
            tail = previous;
        }

        size--;
        return current.getValue();
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        if (toRemove == null) {
            throw new NullPointerException("Cannot remove null element");
        }

        MyDLLNode<E> current = head;
        while (current != null) {
            if (toRemove.equals(current.getValue())) {
                MyDLLNode<E> previous = current.getPrevious();
                MyDLLNode<E> next = current.getNext();

                if (previous != null) {
                    previous.setNext(next);
                } else {
                    // Removing the first element
                    head = next;
                }

                if (next != null) {
                    next.setPrevious(previous);
                } else {
                    // Removing the last element
                    tail = previous;
                }

                size--;
                return current.getValue();
            }

            current = current.getNext();
        }

        return null; // Element not found
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (toChange == null) {
            throw new NullPointerException("Cannot set null element");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        MyDLLNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        E oldValue = current.getValue();
        current.setValue(toChange);
        return oldValue;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException("Cannot search for null element");
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
            throw new NullPointerException("Array to hold elements cannot be null");
        }

        if (toHold.length < size) {
            toHold = (E[]) new Object[size];
        }

        MyDLLNode<E> current = head;
        for (int i = 0; i < size; i++) {
            toHold[i] = current.getValue();
            current = current.getNext();
        }

        return toHold;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        MyDLLNode<E> current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.getValue();
            current = current.getNext();
        }
        return array;
    }


    @Override
    public Iterator<E> iterator() {
        return new IteratorDLL<E>(head);
    }
}
