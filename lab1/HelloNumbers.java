public class HelloNumbers {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 10; i += 1) {
            sum += i;
            System.out.print(sum + " "); // can't change to sum + ' '.
        } // because ' ' means a single char and " " means a string.s
        System.out.println();
    }
}
