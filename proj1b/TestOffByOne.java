import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    //interface class is instantiated with implementation class???

    // Your tests go here.
    @Test
    public void testOffByOne() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertFalse(offByOne.equalChars('a', 'c'));
        assertFalse(offByOne.equalChars('a', 'A'));
        assertTrue(offByOne.equalChars('A', 'B'));
        assertFalse(offByOne.equalChars('B', 'c'));
        assertTrue(offByOne.equalChars('&', '%'));
    }
}
