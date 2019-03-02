import java.util.ArrayList;

@SuppressWarnings("WeakerAccess")
public final class Helpers {

    public static int fib(int n) {
        if (n <= 2) return n;
        else return fibIter(1, 1, n);
    }

    private static int fibIter(int a, int b, int n) {
        if (n == 0) return a;
        else return fibIter(b, a + b, n - 1);
    }

    public static boolean isPrime(long num) {
        if (num < 2)
            return false;
        else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0)
                    return false;
            }

            return true;
        }
    }

    public static ArrayList<Integer> getPrimeFactors(long num) {
        ArrayList<Integer> factors = new ArrayList<>();

        long n = num;
        int check = 2;

        while (n > 1) {
            if (n % check == 0 && isPrime(check)) {
                n /= check;
                factors.add(check);
                check = 2;
            }

            check++;
        }

        return factors;
    }

    public static boolean isPalindrome(int num) {
        StringBuilder n = new StringBuilder(Integer.toString(num));

        String start = n.substring(0, n.length() / 2);
        String end   = n.substring((n.length() + 1) / 2);

        return start.equals(new StringBuilder(end).reverse().toString());
    }

    public static int lcm(int a, int b) {
        int max = Math.max(a, b);
        int lcm = max;

        while (!(lcm % a == 0 && lcm % b == 0))
            lcm += max;

        return lcm;
    }

}
