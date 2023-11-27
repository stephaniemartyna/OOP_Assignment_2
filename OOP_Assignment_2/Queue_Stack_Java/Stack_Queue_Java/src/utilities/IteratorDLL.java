package utilities;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorDLL<E> implements Iterator<E> {
    private E[] elements;
    private int currentIndex;

    public IteratorDLL(E[] elements) {
        this.elements = elements;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < elements.length;
    }

    @Override
    public E next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements");
        }

        E value = elements[currentIndex];
        currentIndex++;
        return value;
    }
}