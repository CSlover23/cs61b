import static org.junit.Assert.*;

import org.junit.Test;

public class FlikTest {

    @Test
    public void testisSameNumber(){
        assertEquals(true, Flik.isSameNumber(1, 1));
        assertEquals(false, Flik.isSameNumber(-1, 5));
        assertEquals(true, Flik.isSameNumber(128, 128));
    }

    public static void main(String... args) {
        jh61b.junit.TestRunner.runTests("failed", FlikTest.class);
    }
}

