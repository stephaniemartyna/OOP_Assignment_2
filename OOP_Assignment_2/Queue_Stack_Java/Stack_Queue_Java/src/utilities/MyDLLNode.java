package utilities;

public class MyDLLNode<E> {
    E value;

    private MyDLLNode<E> next;
    private MyDLLNode<E> previous;

    private int size;

    private MyDLLNode<E> head;

    public MyDLLNode(E item) {
        this.value = item;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public MyDLLNode<E> getNext() {
        return next;
    }

    public void setNext(MyDLLNode<E> next) {
        this.next = next;
    }

    public MyDLLNode<E> getPrevious() {
        return previous;
    }

    public void setPrevious(MyDLLNode<E> previous) {
        this.previous = previous;
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
}
