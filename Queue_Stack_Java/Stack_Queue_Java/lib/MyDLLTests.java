import utilities.MyDLL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyDLLTests {

    private MyDLL<Integer> myDLL;

    @BeforeEach
    public void setUp() {
        // Create a new MyDLL before each test
        myDLL = new MyDLL<>();
    }

    @Test
    public void testSize() {
        assertEquals(0, myDLL.size());
        myDLL.add(42);
        assertEquals(1, myDLL.size());
        myDLL.add(3);
        myDLL.add(7);
        assertEquals(3, myDLL.size());
    }

    @Test
    public void testClear() {
        myDLL.add(1);
        myDLL.add(2);
        myDLL.add(3);
        myDLL.clear();
        assertEquals(0, myDLL.size());
    }

    @Test
    public void testAddAtIndex() {
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
        myDLL.add(0, 1);
        myDLL.add(1, 2);
        myDLL.add(2, 3);
        assertEquals(3, myDLL.size());
        assertEquals(Integer.valueOf(1), myDLL.get(0));
        assertEquals(Integer.valueOf(2), myDLL.get(1));
        assertEquals(Integer.valueOf(3), myDLL.get(2));
    }

    @Test
    public void testAddAll() {
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
        myDLL.add(1);
        myDLL.add(2);
        myDLL.add(3);
        assertEquals(Integer.valueOf(1), myDLL.get(0));
        assertEquals(Integer.valueOf(2), myDLL.get(1));
        assertEquals(Integer.valueOf(3), myDLL.get(2));
    }

    @Test
    public void testRemoveAtIndex() {
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
        assertTrue(myDLL.isEmpty());
        myDLL.add(1);
        assertFalse(myDLL.isEmpty());
    }

    @Test
    public void testContains() {
        myDLL.add(1);
        myDLL.add(2);
        myDLL.add(3);
        assertTrue(myDLL.contains(2));
        assertFalse(myDLL.contains(4));
    }

    @Test
    public void testToArray() {
        myDLL.add(1);
        myDLL.add(2);
        myDLL.add(3);
        Object[] array = myDLL.toArray();
        assertArrayEquals(new Object[] { 1, 2, 3 }, array);
    }

    @Test
    public void testToArrayWithDestinationArray() {
        myDLL.add(1);
        myDLL.add(2);
        myDLL.add(3);
        Integer[] destinationArray = new Integer[3];
        Integer[] resultArray = myDLL.toArray(destinationArray);
        assertSame(destinationArray, resultArray);
        assertArrayEquals(new Integer[] { 1, 2, 3 }, resultArray);
    }
}
