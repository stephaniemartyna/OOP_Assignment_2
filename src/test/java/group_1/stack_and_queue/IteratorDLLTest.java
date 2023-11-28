package group_1.stack_and_queue;

import group_1.stack_and_queue.MyDLLNode;
import group_1.stack_and_queue.IteratorDLL;
import java.util.NoSuchElementException;
import org.junit.Test;
import static org.junit.Assert.*;

public class IteratorDLLTest {

    @Test
    public void testIterator() {
        // Create a linked list with nodes
        MyDLLNode<Integer> node1 = new MyDLLNode<>(1);
        MyDLLNode<Integer> node2 = new MyDLLNode<>(2);
        MyDLLNode<Integer> node3 = new MyDLLNode<>(3);

        // Link the nodes
        node1.setNext(node2);
        node2.setPrevious(node1);
        node2.setNext(node3);
        node3.setPrevious(node2);

        // Create an instance of IteratorDLL
        IteratorDLL<Integer> iterator = new IteratorDLL<>(node1);

        // Check if hasNext and next work as expected
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(1), iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(2), iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(3), iterator.next());

        assertFalse(iterator.hasNext());

        // Trying to call next after reaching the end should throw
        // NoSuchElementException
        try {
            iterator.next();
            fail("Expected NoSuchElementException not thrown");
        } catch (NoSuchElementException e) {
            // Exception is expected
        }
    }
}
