/**
 * Queue interface with all the required functionalities
 */
public interface QueueADT<T> {
    /**
     * Adds an element to the back of the queue.
     *
     * @param element The element to be added to the queue.
     * @throws NullPointerException if the specified element is null.
     */
    void enqueue(T element);

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return The element at the front of the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    T dequeue();

    /**
     * Retrieves, but does not remove, the element at the front of the queue.
     *
     * @return The element at the front of the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    T peek();

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the queue.
     *
     * @return The number of elements in the queue.
     */
    int size();

    /**
     * Returns a string representation of the queue.
     * 
     * @return a string representation of the queue.
     */
    public String toString();

}
