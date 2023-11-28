package group_1.stack_and_queue;

import group_1.stack_and_queue.MyArrayList;
import static junit.framework.TestCase.*;
import org.junit.*;

public class MyArrayListTests {

    private MyArrayList<Integer> myArrayList;

    @Before
    public void setUp() {
        // Create a new MyArrayList before each test
        myArrayList = new MyArrayList<>();
    }

    // ListADT Tests

    @Test
    public void testSize() {
        // Test the size after adding elements
        assertEquals(0, myArrayList.size());
        myArrayList.add(42);
        assertEquals(1, myArrayList.size());
        myArrayList.add(88);
        assertEquals(2, myArrayList.size());
    }

    @Test
    public void testClear() {
        // Test clearing the list
        myArrayList.add(42);
        myArrayList.add(88);
        myArrayList.clear();
        assertEquals(0, myArrayList.size());
        assertTrue(myArrayList.isEmpty());
    }

    @Test
    public void testAddElementAtIndex() {
        // Test adding an element at a specific index
        myArrayList.add(42);
        myArrayList.add(88);
        myArrayList.add(1, 100);
        assertEquals(3, myArrayList.size());
    }

    @Test
    public void testAddElement() {
        // Test adding a single element
        myArrayList.add(42);
        assertEquals(1, myArrayList.size());
    }

    @Test
    public void testAddAll() {
        // Test adding all elements from another list
        MyArrayList<Integer> toAddList = new MyArrayList<>();
        toAddList.add(1);
        toAddList.add(2);
        toAddList.add(3);

        myArrayList.addAll(toAddList);

        assertEquals(3, myArrayList.size());
        assertEquals(Integer.valueOf(1), myArrayList.get(0));
        assertEquals(Integer.valueOf(2), myArrayList.get(1));
        assertEquals(Integer.valueOf(3), myArrayList.get(2));
    }

    @Test
    public void testGetElement() {
        // Test retrieving an element at a specific index
        myArrayList.add(42);
        int element = myArrayList.get(0);
        assertEquals(42, element);
    }

    @Test
    public void testRemoveElement() {
        // Test removing an element by value
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.remove(1);
        assertEquals(2, myArrayList.size());
    }

    @Test
    public void testRemoveElementAtIndex() {
        // Test removing an element by index
        myArrayList.add(42);
        myArrayList.add(88);
        int removed = myArrayList.remove(1);
        assertEquals(88, removed);
        assertEquals(1, myArrayList.size());
    }

    @Test
    public void testSetElement() {
        // Test setting an element at a specific index
        myArrayList.add(42);
        myArrayList.add(88);
        int previous = myArrayList.set(1, 100);
        assertEquals(88, previous);
    }

    @Test
    public void testIsEmpty() {
        // Test checking if the list is empty
        assertTrue(myArrayList.isEmpty());

        myArrayList.add(42);
        assertFalse(myArrayList.isEmpty());
    }

    @Test
    public void testContainsElement() {
        // Test checking if the list contains a specific element
        myArrayList.add(42);
        myArrayList.add(88);

        assertTrue(myArrayList.contains(42));
        assertTrue(myArrayList.contains(88));
        assertFalse(myArrayList.contains(100));
    }

    @Test
    public void testToArrayWithArray() {
        // Test converting the list to an array
        myArrayList.add(42);
        myArrayList.add(88);

        Integer[] array = new Integer[2];
        array = myArrayList.toArray(array);

        // Check the elements in the array
        assertEquals(42, array[0].intValue());
        assertEquals(88, array[1].intValue());

        // Check that the size of the array is equal to the size of the list
        assertEquals(myArrayList.size(), array.length);
    }
}
