import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import utilities.MyStack;

public class MyStackTests {

    @Test
    public void testPushAndPeek() {
        MyStack<Integer> stack = new MyStack<>();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.getSize());

        stack.push(1);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.getSize());
        assertEquals(1, stack.peek().intValue());

        stack.push(2);
        assertFalse(stack.isEmpty());
        assertEquals(2, stack.getSize());
        assertEquals(2, stack.peek().intValue());
    }

    @Test
    public void testPop() {
        MyStack<String> stack = new MyStack<>();
        stack.push("First");
        stack.push("Second");

        assertFalse(stack.isEmpty());
        assertEquals(2, stack.getSize());

        int poppedElement = stack.pop();
        assertEquals(2, poppedElement);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.getSize());
        assertEquals("First", stack.peek());

        stack.pop();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.getSize());
    }

    @Test
    public void testCapacity() {
        MyStack<Double> stack = new MyStack<>(3);
        assertEquals(3, stack.getCapacity());

        stack.push(1.0);
        stack.push(2.0);
        stack.push(3.0);
        assertEquals(3, stack.getSize());
        assertEquals(3.0, stack.peek());
    }

    @Test
    public void testIsEmpty() {
        MyStack<Character> stack = new MyStack<>();
        assertTrue(stack.isEmpty());

        stack.push('A');
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPopEmptyStack() {
        MyStack<Integer> stack = new MyStack<>();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPeekEmptyStack() {
        MyStack<String> stack = new MyStack<>();
        assertTrue(stack.isEmpty());
    }
}
