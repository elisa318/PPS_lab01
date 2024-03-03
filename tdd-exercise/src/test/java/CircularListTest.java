import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.CircularList;
import tdd.CircularListImplementation;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    CircularList circularList;
    private static int ADDED_ELEMENT = 1;
    private static int START_VALUE = 0;

    @BeforeEach
    void beforeEach() {
        circularList = new CircularListImplementation();
    }

    @Test 
    public void testAddToCircularList() {
        circularList.add(ADDED_ELEMENT);
        assertEquals(Optional.of(ADDED_ELEMENT), circularList.next());
    }

    @Test
    public void testIsEmpty() {
        assertEquals(START_VALUE, circularList.size());
    }

    @Test 
    public void testSize () {
        circularList.add(ADDED_ELEMENT);
        assertEquals(ADDED_ELEMENT, circularList.size());
    }

    @Test 
    public void testGetPreviousElement() {
        circularList.add(ADDED_ELEMENT);
        circularList.add(2);
        circularList.add(3);
        circularList.next();
        assertEquals(Optional.of(3), circularList.next());
    }

}
