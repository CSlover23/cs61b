import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void studentTest() {

        StudentArrayDeque<Integer> testArray = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solArray = new ArrayDequeSolution<>();
        String message = "\n";

        for (int i = 0; i < 100; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            Integer actual;
            Integer expected;

            if (numberBetweenZeroAndOne < 0.5) {
                testArray.addLast(i);
                solArray.addLast(i);

                actual = testArray.size();
                expected = solArray.size();
                message += "size()\n";
                assertEquals(message, expected, actual);

                actual = testArray.get(testArray.size() - 1);
                expected = solArray.get(solArray.size() - 1);
                message += "addLast(" + i + ")\n";
                assertEquals(message, expected, actual);
            } else {
                testArray.addFirst(i);
                solArray.addFirst(i);
                actual = testArray.get(0);
                expected = solArray.get(0);

                message += "addFirst(" + i + ")\n";
                assertEquals(message, expected, actual);
            }

            if (i % 3 == 0) {
                actual = testArray.removeFirst();
                expected = solArray.removeFirst();

                message += "removeFirst()\n";
                assertEquals(message, expected, actual);
            }

            if (i % 4 == 0) {
                actual = testArray.removeLast();
                expected = solArray.removeLast();

                message += "removeLast()\n";
                assertEquals(message, expected, actual);
            }
        }

    }
}
