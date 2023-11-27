import utilities.IteratorDLL;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

public class IteratorDLLTest {

    @Test
    public void testIterator() {
        Integer[] elementsArray = { 1, 2, 3 };
        // Create an instance of IteratorDLLList
        IteratorDLL<Integer> iterator = new IteratorDLL<>(elementsArray);

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
        }
    }
}