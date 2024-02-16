import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void studentTest() {

        StudentArrayDeque<Integer> testArray = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solArray = new ArrayDequeSolution<>();
        String message = "\n";
        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            Integer input = StdRandom.uniform(1000);
            if (numberBetweenZeroAndOne < 0.5) {
                testArray.addLast(input);
                solArray.addLast(input);
                Integer expected = solArray.get(testArray.size() - 1);
                message += "addLast(" + expected + ")\n";
                Integer actual = testArray.get(testArray.size() - 1);
                assertEquals(message, expected, actual);
            } else {
                testArray.addFirst(i);
                solArray.addLast(input);
                Integer expected = solArray.get(0);
                message += "addFirst(" + expected + ")\n";
                Integer actual = testArray.get(0);
                assertEquals(message, expected, actual);
            }

            if (i == 5) {
                Integer expected = solArray.get(i - 1);
                Integer actual = testArray.removeLast();
                message += "removeLast()\n";
                assertEquals(message, expected, actual);
            }

            if (i == 8) {
                Integer expected = solArray.get(0);
                Integer actual = testArray.removeFirst();
                message += "removeFirst()\n";
                assertEquals(message, expected, actual);
            }
        }
    }
}
