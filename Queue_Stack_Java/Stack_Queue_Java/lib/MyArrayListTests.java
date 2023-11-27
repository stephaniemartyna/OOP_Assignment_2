import utilities.MyArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class MyArrayListTests {

    private MyArrayList<Integer> myArrayList;

    @BeforeEach
    public void setUp() {
        // Create a new MyArrayList before each test
        myArrayList = new MyArrayList<>();
    }

    // ListADT Tests
    @Test
    public void testSize() {
        assertEquals(0, myArrayList.size());

        myArrayList.add(42);
        assertEquals(1, myArrayList.size());

        myArrayList.add(88);
        assertEquals(2, myArrayList.size());
    }

    @Test
    public void testClear() {
        myArrayList.add(42);
        myArrayList.add(88);

        myArrayList.clear();

        assertEquals(0, myArrayList.size());
        assertTrue(myArrayList.isEmpty());
    }

    @Test
    public void testAddElementAtIndex() {
        myArrayList.add(42);
        myArrayList.add(88);
        myArrayList.add(1, 100);
        assertEquals(3, myArrayList.size());
        assertEquals(100, myArrayList.get(1));
    }

    @Test
    public void testAddElement() {
        myArrayList.add(42);
        assertEquals(1, myArrayList.size());
    }

    @Test
    public void testAddAll() {
        // Create a list to add elements
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
        myArrayList.add(42);
        int element = myArrayList.get(0);
        assertEquals(42, element);
    }

    @Test
    public void testRemoveElement() {
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.remove(1);
        assertEquals(2, myArrayList.size());
    }

    @Test
    public void testRemoveElementAtIndex() {
        myArrayList.add(42);
        myArrayList.add(88);
        int removed = myArrayList.remove(1);
        assertEquals(88, removed);
        assertEquals(1, myArrayList.size());
    }

    @Test
    public void testSetElement() {
        myArrayList.add(42);
        myArrayList.add(88);
        int previous = myArrayList.set(1, 100);
        assertEquals(88, previous);
        assertEquals(100, myArrayList.get(1));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(myArrayList.isEmpty());

        myArrayList.add(42);
        assertFalse(myArrayList.isEmpty());
    }

    @Test
    public void testContainsElement() {
        myArrayList.add(42);
        myArrayList.add(88);

        assertTrue(myArrayList.contains(42));
        assertTrue(myArrayList.contains(88));
        assertFalse(myArrayList.contains(100));
    }

    @Test
    public void testToArray() {
        myArrayList.add(42);
        myArrayList.add(88);

        Object[] array = myArrayList.toArray();
        assertEquals(42, array[0]);
        assertEquals(88, array[1]);
    }

    // public E[] toArray(E[] toHold) throws NullPointerException;
    @Test
    public void testToArrayWithArray() {
        myArrayList.add(42);
        myArrayList.add(88);

        Integer[] array = new Integer[2];
        array = myArrayList.toArray(array);
        assertEquals(42, array[0]);
        assertEquals(88, array[1]);
    }

}
