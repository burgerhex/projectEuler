import java.util.ArrayList;
import java.util.Collections;

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

    public static ArrayList<Long> getFactors(long num) {
        ArrayList<Long> factors = new ArrayList<>();

        for (long i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (!factors.contains(i))       factors.add(i);
                if (!factors.contains(num / i)) factors.add(num / i);
            }
        }

        Collections.sort(factors);

        return factors;
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

    public static ArrayList<Long> collatzChain(long num) {
        ArrayList<Long> chain = new ArrayList<>();
        chain.add(num);

        while (num != 1) {
            if (num % 2 == 0)
                num /= 2;
            else
                num = 3 * num + 1;
            chain.add(num);
        }

        return chain;
    }

    public static boolean isPalindrome(int num) {
        String forward = Integer.toString(num);
        String reverse = new StringBuilder(forward).reverse().toString();

        return forward.equals(reverse);
    }

    public static int lcm(int a, int b) {
        int max = Math.max(a, b);
        int lcm = max;

        while (!(lcm % a == 0 && lcm % b == 0))
            lcm += max;

        return lcm;
    }

}
