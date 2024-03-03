package synthesizer;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayRingBuffer {

    ArrayRingBuffer<Integer> tester = new ArrayRingBuffer<>(8);
    //tester.enqueue(8); //If you call here, then you will be wrong but why!!!

    @Test
    public void testCapacity() {;
        tester.enqueue(8);
        assertEquals(tester.capacity(), 8);
    }

}
