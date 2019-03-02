import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * A runner class to see the solutions to the ProjectEuler problems.
 * @author Aviv Shai
 * @author burgerhex
 * @version 1.0.5
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class Main {

    /**
     * The runner method for this class.
     * @param args arguments that don't make any difference
     * @see Main#printProblem(int) printProblem
     */
    public static void main(String[] args) {
        printProblems(1, 7);
    }

    /**
     * Problem number 1 found at https://projecteuler.net/problem=2.
     */
    private static final Problem PROBLEM1 = new Problem() {
        @Override
        public int solve() {
            int sum = 0;

            for (int i = 1; i < 1000; i++) {
                if (i % 3 == 0 || i % 5 == 0) {
                    sum += i;
                }
            }

            return sum;
        }
    };

    /**
     * Problem number 2 found at https://projecteuler.net/problem=2.
     */
    private static final Problem PROBLEM2 = new Problem() {
        @Override
        public int solve() {
            int sum = 0;

            for (int n = 0; Helpers.fib(n) <= 4000000; n++) {
                if (Helpers.fib(n) % 2 == 0)
                    sum += Helpers.fib(n);
            }

            return sum;
        }
    };

    /**
     * Problem number 3 found at https://projecteuler.net/problem=3.
     */
    private static final Problem PROBLEM3 = new Problem() {
        @Override
        public int solve() {
            int max = 0;

            for (int factor : Helpers.getPrimeFactors(600851475143L)) {
                if (factor > max)
                    max = factor;
            }

            return max;
        }
    };

    /**
     * Problem number 4 found at https://projecteuler.net/problem=4.
     */
    private static final Problem PROBLEM4 = new Problem() {
        @Override
        public int solve() {
            int max = 0;

            for (int i = 999; i >= 100; i--) {
                for (int j = 999; j >= 100; j--) {
                    if (Helpers.isPalindrome(i * j) && i * j > max)
                        max = i * j;
                }
            }
            return max;
        }
    };

    /**
     * Problem number 5 found at https://projecteuler.net/problem=5.
     */
    private static final Problem PROBLEM5 = new Problem() {
        @Override
        public int solve() {
            int lcm = Helpers.lcm(1, 2);

            for (int check = 3; check <= 20; check++)
                lcm = Helpers.lcm(lcm, check);

            return lcm;
        }
    };

    /**
     * Problem number 6 found at https://projecteuler.net/problem=6.
     */
    private static final Problem PROBLEM6 = new Problem() {
        @Override
        public int solve() {
            int sumOfSquares = 0;
            int sum          = 0;

            for (int i = 1; i <= 100; i++) {
                sumOfSquares += (int) Math.pow(i, 2);
                sum          += i;
            }

            int sumSquared = (int) Math.pow(sum, 2);

            return Math.abs(sumOfSquares - sumSquared);
        }
    };

    /**
     * Problem number 7 found at https://projecteuler.net/problem=7.
     */
    private static final Problem PROBLEM7 = new Problem() {
        @Override
        public int solve() {
            ArrayList<Integer> primes = new ArrayList<>();

            primes.add(2);
            for (int i = 3; primes.size() <= 10001; i += 2) {
                if (Helpers.isPrime(i))
                    primes.add(i);
            }

            return primes.get(10000);
        }
    };

    /**
     * Prints the solutions to multiple problems from this class.
     * @param first the number of the first problem to print
     * @param last the number of the last problem to print
     * @see Main#printProblem(int) printProblem
     */
    private static void printProblems(int first, int last) {
        for (int i = first; i <= last; i++) {
            printProblem(i);
        }
    }

    /**
     * Prints the solution to a problem from this class from a specified number.
     * @param num the number of the problem to find and print
     * @throws IllegalArgumentException if problem couldn't be found, accessed, or casted correctly.
     * @see Problem
     * @see Problem#solve() solve
     */
    private static void printProblem(int num) {
        Field field;
        Problem problem;

        try {
            field = Main.class.getDeclaredField("PROBLEM" + num);
            field.setAccessible(true);
            problem = (Problem) field.get(null);
        } catch (NoSuchFieldException e) {
            throw new IllegalArgumentException("problem number " + num + " is not implemented yet " +
                    "or is not correctly called \"problem" + num + "\"");
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("problem number " + num + " couldn't be accessed");
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("object couldn't be casted to Problem; is its type Problem?");
        }

        long startTime = System.nanoTime();
        int solution = problem.solve();
        long endTime   = System.nanoTime();

        double seconds = (endTime - startTime) / 1000000000.0;

        System.out.format("Solution to problem %3d: %10d [%.3f seconds]\n", num, solution, seconds);
    }

}