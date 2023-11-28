package group_1.stack_and_queue;

import group_1.stack_and_queue.MyStack;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyStackTests {

    @Test
    public void testPushAndPeek() {
        // Create a stack of integers
        MyStack<Integer> stack = new MyStack<>();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        // Push elements onto the stack
        stack.push(1);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(1, stack.peek().intValue());

        stack.push(2);
        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());
        assertEquals(2, stack.peek().intValue());
    }

    @Test
    public void testPop() {
        // Create a stack of strings
        MyStack<String> stack = new MyStack<>();
        stack.push("First");
        stack.push("Second");

        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());

        // Pop an element from the stack
        String poppedElement = stack.pop();
        assertEquals("Second", poppedElement);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals("First", stack.peek());

        // Pop another element from the stack
        stack.pop();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void testIsEmpty() {
        // Create a stack of characters
        MyStack<Character> stack = new MyStack<>();
        assertTrue(stack.isEmpty());

        // Push a character onto the stack
        stack.push('A');
        assertFalse(stack.isEmpty());

        // Pop the character from the stack
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPopEmptyStack() {
        // Create an empty stack of integers
        MyStack<Integer> stack = new MyStack<>();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPeekEmptyStack() {
        // Create an empty stack of strings
        MyStack<String> stack = new MyStack<>();
        assertTrue(stack.isEmpty());
    }
}
