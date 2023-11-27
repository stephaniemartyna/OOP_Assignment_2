package utilities;

import java.util.NoSuchElementException;

public class IteratorMyArrayList<E> implements Iterator<E> {
    private E[] elements;
    private int currentIndex;

    public IteratorMyArrayList(E[] elements) {
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

        return elements[currentIndex++];
    }
}
