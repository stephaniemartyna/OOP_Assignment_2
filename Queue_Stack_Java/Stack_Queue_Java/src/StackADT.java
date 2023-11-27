
public interface StackADT<T> {

    /**
     * Adds one element to the top of this stack.
     * 
     * @param element
     * @throws NullPointerException if the specified element is null.
     */
    public void push(T element);

    /**
     * Removes and returns the top element from this stack.
     * 
     * @return the element removed from the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T pop();

    /**
     * Returns without removing the top element of this stack.
     * 
     * @return the element on top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T peek();

    /**
     * Returns true if this stack contains no elements.
     * 
     * @return true if the stack is empty
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this stack.
     * 
     * @return the number of elements in the stack
     */
    public int size();

    /**
     * Returns a string representation of this stack.
     * 
     * @return a string representation of the stack
     */
    public String toString();

}
