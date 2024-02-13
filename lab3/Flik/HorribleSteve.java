public class HorribleSteve {
    public static void main(String [] args) {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            if (!Flik.isSameNumber(i, j)) {
                break; // break exits the for loop!
            }
        } //WRONG ANSWER MAY BE BECAUSE LIBRARY USES Interger WHILE int HERE
        System.out.println("i is " + i);
    }
}
