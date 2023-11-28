package group_1.stack_and_queue;

import java.util.NoSuchElementException;

public class IteratorDLL<E> implements Iterator<E> {
    private MyDLLNode<E> current;

    public IteratorDLL(MyDLLNode<E> head) {
        this.current = head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public E next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements");
        }

        E value = current.getValue();
        current = current.getNext();
        return value;
    }
}
