package group_1.stack_and_queue;

/**
 * Implementation of the QueueADT interface using a doubly linked list.
 *
 * @param <E> The type of elements in the queue.
 */
public class MyQueue<E> implements QueueADT<E> {
    private MyDLL<E> myDLL;

    public MyQueue() {
        // Initialize the doubly linked list
        myDLL = new MyDLL<>();
    }

    @Override
    public void enqueue(E toAdd) throws NullPointerException {
        // Check for null element
        if (toAdd == null) {
            throw new NullPointerException("Cannot add null element to the queue");
        }
        // Add the element to the end of the queue
        myDLL.add(toAdd);
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        // Check if the queue is empty
        if (isEmpty()) {
            throw new EmptyQueueException("Cannot dequeue from an empty queue");
        }
        // Remove and return the element from the front of the queue
        return myDLL.remove(0);
    }

    @Override
    public E peek() throws EmptyQueueException {
        // Check if the queue is empty
        if (isEmpty()) {
            throw new EmptyQueueException("Cannot peek into an empty queue");
        }
        // Return the element at the front of the queue
        return myDLL.get(0);
    }

    @Override
    public void dequeueAll() {
        // Clear all elements from the queue
        myDLL.clear();
    }

    @Override
    public boolean isEmpty() {
        // Check if the queue is empty using the underlying DLL
        return myDLL.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        // Return an iterator from the underlying DLL
        return myDLL.iterator();
    }

    @Override
    public boolean equals(QueueADT<E> that) {
        // Check for null and size mismatch
        if (that == null || this.size() != that.size()) {
            return false;
        }

        // Create iterators for both queues
        Iterator<E> thisIterator = this.iterator();
        Iterator<E> thatIterator = that.iterator();

        // Compare elements using iterators
        while (thisIterator.hasNext()) {
            if (!thisIterator.next().equals(thatIterator.next())) {
                return false;
            }
        }

        // Queues are equal
        return true;
    }

    @Override
    public Object[] toArray() {
        // Convert the queue to an array using the underlying DLL
        return myDLL.toArray();
    }

    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        // Convert the queue to an array using the underlying DLL
        return myDLL.toArray(holder);
    }

    @Override
    public boolean isFull() {
        // Will always be false because we did not set a fixed capacity
        return false;
    }

    @Override
    public int size() {
        // Return the size of the queue using the underlying DLL
        return myDLL.size();
    }
}
