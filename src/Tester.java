public class Tester {

    public static void main(String[] args) {
        print(problem1());
    }

    private static <T> void print(T answer) {
        System.out.println(answer);
    }

    private static int problem1() {
        // https://projecteuler.net/problem=1

        int sum = 0;

        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }

        return sum;
    }

}