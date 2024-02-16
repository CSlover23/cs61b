import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void studentTest() {

        StudentArrayDeque<Integer> testArray = new StudentArrayDeque<>();
        String message = "\n";
        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            Integer expected = StdRandom.uniform(1000);
            if (numberBetweenZeroAndOne < 0.5) {
                testArray.addLast(expected);
                message += "addLast(" + expected + ")\n";
                Integer actual = testArray.get(i);
                assertEquals(message, expected, actual);
            } else {
                testArray.addFirst(i);
                message += "addFirst(" + expected + ")\n";
                Integer actual = testArray.get(0);
                assertEquals(message, expected, actual);
            }

            if (i == 5) {
                expected = testArray.get(i - 1);
                Integer actual = testArray.removeLast();
                message += "removeLast()\n";
                assertEquals(message, expected, actual);
            }

            if (i == 8) {
                expected = testArray.get(0);
                Integer actual = testArray.removeFirst();
                message += "removeFirst()\n";
                assertEquals(message, expected, actual);
            }
        }
    }
}
