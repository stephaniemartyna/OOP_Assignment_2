package group_1.stack_and_queue;

import group_1.stack_and_queue.MyDLL;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyDLLTests {

    private MyDLL<Integer> myDLL;

    @Before
    public void setUp() {
        // Create a new MyDLL before each test
        myDLL = new MyDLL<>();
    }

    @Test
    public void testSize() {
        // Test the size after adding elements
        assertEquals(0, myDLL.size());
        myDLL.add(42);
        assertEquals(1, myDLL.size());
        myDLL.add(3);
        myDLL.add(7);
        assertEquals(3, myDLL.size());
    }

    @Test
    public void testClear() {
        // Test clearing the list
        myDLL.add(1);
        myDLL.add(2);
        myDLL.add(3);
        myDLL.clear();
        assertEquals(0, myDLL.size());
    }

    @Test
    public void testAddAtIndex() {
        // Test adding an element at a specific index
        myDLL.add(0, 1);
        myDLL.add(1, 3);
        myDLL.add(1, 2);
        assertEquals(3, myDLL.size());
        assertEquals(Integer.valueOf(1), myDLL.get(0));
        assertEquals(Integer.valueOf(2), myDLL.get(1));
        assertEquals(Integer.valueOf(3), myDLL.get(2));
    }

    @Test
    public void testAdd() {
        // Test adding a single element
        myDLL.add(1);
        myDLL.add(2);
        myDLL.add(3);
        assertEquals(3, myDLL.size());
        assertEquals(Integer.valueOf(1), myDLL.get(0));
        assertEquals(Integer.valueOf(2), myDLL.get(1));
        assertEquals(Integer.valueOf(3), myDLL.get(2));
    }

    @Test
    public void testAddAll() {
        // Test adding all elements from another list
        MyDLL<Integer> toAddList = new MyDLL<>();
        toAddList.add(1);
        toAddList.add(2);
        toAddList.add(3);
        toAddList.add(4);
        toAddList.add(5);

        myDLL.addAll(toAddList);

        assertEquals(5, toAddList.size());
        assertEquals(Integer.valueOf(1), toAddList.get(0));
        assertEquals(Integer.valueOf(4), toAddList.get(3));
        assertEquals(Integer.valueOf(3), toAddList.get(2));

        assertEquals(5, myDLL.size());
    }

    @Test
    public void testGet() {
        // Test retrieving an element at a specific index
        myDLL.add(1);
        myDLL.add(2);
        myDLL.add(3);
        assertEquals(Integer.valueOf(1), myDLL.get(0));
        assertEquals(Integer.valueOf(2), myDLL.get(1));
        assertEquals(Integer.valueOf(3), myDLL.get(2));
    }

    @Test
    public void testRemoveAtIndex() {
        // Test removing an element by index
        myDLL.add(1);
        myDLL.add(2);
        myDLL.add(3);
        assertEquals(Integer.valueOf(2), myDLL.remove(1));
        assertEquals(2, myDLL.size());
        assertEquals(Integer.valueOf(1), myDLL.get(0));
        assertEquals(Integer.valueOf(3), myDLL.get(1));
    }

    @Test
    public void testRemoveByValue() {
        // Test removing an element by value
        myDLL.add(1);
        myDLL.add(2);
        myDLL.add(3);
        assertEquals(Integer.valueOf(2), myDLL.remove(Integer.valueOf(2)));
        assertEquals(2, myDLL.size());
        assertEquals(Integer.valueOf(1), myDLL.get(0));
        assertEquals(Integer.valueOf(3), myDLL.get(1));
    }

    @Test
    public void testSet() {
        // Test setting an element at a specific index
        myDLL.add(1);
        myDLL.add(2);
        myDLL.add(3);
        assertEquals(Integer.valueOf(2), myDLL.set(1, 4));
        assertEquals(3, myDLL.size());
        assertEquals(Integer.valueOf(1), myDLL.get(0));
        assertEquals(Integer.valueOf(4), myDLL.get(1));
        assertEquals(Integer.valueOf(3), myDLL.get(2));
    }

    @Test
    public void testIsEmpty() {
        // Test checking if the list is empty
        assertTrue(myDLL.isEmpty());
        myDLL.add(1);
        assertFalse(myDLL.isEmpty());
    }

    @Test
    public void testContains() {
        // Test checking if the list contains a specific element
        myDLL.add(1);
        myDLL.add(2);
        myDLL.add(3);
        assertTrue(myDLL.contains(2));
        assertFalse(myDLL.contains(4));
    }

    @Test
    public void testToArray() {
        // Test converting the list to an array
        myDLL.add(1);
        myDLL.add(2);
        myDLL.add(3);
        Object[] array = myDLL.toArray();
        assertArrayEquals(new Object[] { 1, 2, 3 }, array);
    }

    @Test
    public void testToArrayWithDestinationArray() {
        // Test converting the list to an array with a destination array
        myDLL.add(1);
        myDLL.add(2);
        myDLL.add(3);
        Integer[] destinationArray = new Integer[3];
        Integer[] resultArray = myDLL.toArray(destinationArray);
        assertSame(destinationArray, resultArray);
        assertArrayEquals(new Integer[] { 1, 2, 3 }, resultArray);
    }
}
