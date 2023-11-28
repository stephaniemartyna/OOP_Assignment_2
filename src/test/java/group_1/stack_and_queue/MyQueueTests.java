package group_1.stack_and_queue;

import group_1.stack_and_queue.EmptyQueueException;
import group_1.stack_and_queue.MyQueue;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyQueueTests {

    @Test
    public void testEnqueueAndPeek() throws EmptyQueueException {
        // Create a queue of integers
        MyQueue<Integer> queue = new MyQueue<>();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());

        // Enqueue elements
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
        assertEquals(Integer.valueOf(1), queue.peek());

        queue.enqueue(2);
        assertFalse(queue.isEmpty());
        assertEquals(2, queue.size());
        assertEquals(Integer.valueOf(1), queue.peek());
    }

    @Test
    public void testDequeue() throws EmptyQueueException {
        // Create a queue of integers
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);

        assertFalse(queue.isEmpty());
        assertEquals(2, queue.size());

        // Dequeue an element
        int dequeuedElement = queue.dequeue();
        assertEquals(1, dequeuedElement);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());

        // Dequeue another element
        queue.dequeue();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void testDequeueEmptyQueue() throws EmptyQueueException {
        // Create an empty queue
        MyQueue<Integer> queue = new MyQueue<>();
        // Dequeue from an empty queue should throw EmptyQueueException
        try {
            queue.dequeue();
            fail("Expected EmptyQueueException not thrown");
        } catch (EmptyQueueException e) {
            // Expected exception
        }
    }

    @Test
    public void testPeekEmptyQueue() throws EmptyQueueException {
        // Create an empty queue
        MyQueue<Integer> queue = new MyQueue<>();
        // Peek into an empty queue should throw EmptyQueueException
        try {
            queue.peek();
            fail("Expected EmptyQueueException not thrown");
        } catch (EmptyQueueException e) {
            // Expected exception
        }
    }

    @Test
    public void testDequeueAll() {
        // Create a queue of integers
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertFalse(queue.isEmpty());
        assertEquals(3, queue.size());

        // Dequeue all elements
        queue.dequeueAll();

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void testEquals() {
        // Create two equal queues
        MyQueue<Integer> queue1 = new MyQueue<>();
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);

        MyQueue<Integer> queue2 = new MyQueue<>();
        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);

        // Two equal queues should be equal
        assertTrue(queue1.equals(queue2));
    }

    @Test
    public void testNotEquals() {
        // Create two queues with different elements
        MyQueue<Integer> queue1 = new MyQueue<>();
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);

        MyQueue<Integer> queue2 = new MyQueue<>();
        queue2.enqueue(3);
        queue2.enqueue(2);
        queue2.enqueue(1);

        // Two queues with different elements should not be equal
        assertFalse(queue1.equals(queue2));
    }

    @Test
    public void testToArray() {
        // Create a queue of integers
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Convert the queue to an array
        Object[] array = queue.toArray();

        assertArrayEquals(new Object[]{1, 2, 3}, array);
    }

    @Test
    public void testToArrayWithHolder() {
        // Create a queue of integers
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Create a holder array
        Integer[] holder = new Integer[3];

        // Convert the queue to an array using the holder
        Integer[] resultArray = queue.toArray(holder);

        assertSame(holder, resultArray);
        assertArrayEquals(new Integer[]{1, 2, 3}, resultArray);
    }

    @Test
    public void testIsFull() {
        // MyQueue implementation does not have a fixed capacity
        // isFull should always return false
        MyQueue<Integer> queue = new MyQueue<>();
        assertFalse(queue.isFull());
    }
}
