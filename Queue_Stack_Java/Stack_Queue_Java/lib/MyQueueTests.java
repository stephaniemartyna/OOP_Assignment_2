
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import utilities.MyQueue;

public class MyQueueTests {

     @Test
    public void testEnqueueAndPeek() {
        MyQueue queue = new MyQueue(); // Using raw type
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.getSize());

        queue.enqueue(1);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.getSize());
        assertEquals(1, ((Integer) queue.peek()).intValue());

        queue.enqueue(2);
        assertFalse(queue.isEmpty());
        assertEquals(2, queue.getSize());
        assertEquals(1, ((Integer) queue.peek()).intValue());
    }

    @Test
    public void testDequeue() {
        MyQueue queue = new MyQueue(); // Using raw type
        queue.enqueue(1);
        queue.enqueue(2);

        assertFalse(queue.isEmpty());
        assertEquals(2, queue.getSize());

        Object dequeuedElement = queue.dequeue();
        assertEquals(1, dequeuedElement);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.getSize());
        assertEquals(2, queue.peek());

        queue.dequeue();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.getSize());
    }

    @Test
    public void testCapacity() {
        MyQueue queue = new MyQueue(3); // Using raw type
        assertEquals(3, queue.getCapacity());

        queue.enqueue(1.0);
        queue.enqueue(2.0);
        queue.enqueue(3.0);
        assertEquals(3, queue.getSize());

        queue.enqueue(4.0);
        assertEquals(6, queue.getCapacity());
    }

    @Test
    public void testIsEmpty() {
        MyQueue queue = new MyQueue(); // Using raw type
        assertTrue(queue.isEmpty());

        queue.enqueue('A');
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testDequeueEmptyQueue() {
        MyQueue queue = new MyQueue(); // Using raw type
        assertThrows(NoSuchElementException.class, queue::dequeue);
    }

    @Test
    public void testPeekEmptyQueue() {
        MyQueue queue = new MyQueue(); // Using raw type
        assertNull(queue.peek());
    }
}
