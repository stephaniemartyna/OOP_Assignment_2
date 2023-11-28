package group_1.stack_and_queue;

import group_1.stack_and_queue.IteratorMyArrayList;
import java.util.NoSuchElementException;
import static junit.framework.TestCase.*;
import org.junit.*;

public class IteratorMyArrayTest {

    @Test
    public void testIterator() {
        // Create an array of elements for testing
        Integer[] elementsArray = { 1, 2, 3, 4, 5 };

        // Create an instance of IteratorMyArrayList
        IteratorMyArrayList<Integer> iterator = new IteratorMyArrayList<>(elementsArray);

        // Test hasNext() and next() methods
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(1), iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(2), iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(3), iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(4), iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(5), iterator.next());

        // Test that hasNext() returns false after all elements are iterated
        assertFalse(iterator.hasNext());

        // Test NoSuchElementException when calling next() beyond the end
        try {
            iterator.next();
            fail("Expected NoSuchElementException was not thrown");
        } catch (NoSuchElementException e) {
            // This is expected
        }
    }
}
