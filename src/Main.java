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
        printProblems(1, 8);
    }

    /**
     * Problem number 1 found at https://projecteuler.net/problem=2.
     */
    private static final Problem PROBLEM1 = new Problem() {
        @Override
        public long solve() {
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
        public long solve() {
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
        public long solve() {
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
        public long solve() {
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
        public long solve() {
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
        public long solve() {
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
        public long solve() {
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
     * Problem number 8 found at https://projecteuler.net/problem=8.
     */
    private static final Problem PROBLEM8 = new Problem() {
        @Override
        public long solve() {

            String number =
                    "73167176531330624919225119674426574742355349194934" +
                    "96983520312774506326239578318016984801869478851843" +
                    "85861560789112949495459501737958331952853208805511" +
                    "12540698747158523863050715693290963295227443043557" +
                    "66896648950445244523161731856403098711121722383113" +
                    "62229893423380308135336276614282806444486645238749" +
                    "30358907296290491560440772390713810515859307960866" +
                    "70172427121883998797908792274921901699720888093776" +
                    "65727333001053367881220235421809751254540594752243" +
                    "52584907711670556013604839586446706324415722155397" +
                    "53697817977846174064955149290862569321978468622482" +
                    "83972241375657056057490261407972968652414535100474" +
                    "82166370484403199890008895243450658541227588666881" +
                    "16427171479924442928230863465674813919123162824586" +
                    "17866458359124566529476545682848912883142607690042" +
                    "24219022671055626321111109370544217506941658960408" +
                    "07198403850962455444362981230987879927244284909188" +
                    "84580156166097919133875499200524063689912560717606" +
                    "05886116467109405077541002256983155200055935729725" +
                    "71636269561882670428252483600823257530420752963450";
            long maxProduct = 0;

            for (int i = 0; i < number.length() - 12; i++) {
                String sub = number.substring(i, i + 13);
                long prod13 = 1;

                for (char digit : sub.toCharArray()) {
                    prod13 *= Integer.valueOf(String.valueOf(digit));
                }

                if (prod13 > maxProduct)
                    maxProduct = prod13;
            }

            return maxProduct;
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
        long solution = problem.solve();
        long endTime   = System.nanoTime();

        double seconds = (endTime - startTime) / 1000000000.0;

        System.out.format("Solution to problem %3d: %12d [%.3f seconds]\n", num, solution, seconds);
    }

}