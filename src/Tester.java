import java.lang.reflect.Field;

/**
 * A runner class to see the solutions to the ProjectEuler problems.
 * @author Aviv Shai
 * @author burgerhex
 * @version 1.0.0
 */
public class Tester {

    /**
     * The runner method for this class.
     * @param args arguments that don't make any difference
     * @see Tester#printProblem(int) printProblem
     */
    public static void main(String[] args) {
        printProblem(1);
        printProblem(2);
    }

    /**
     * Problem number 1 found at https://projecteuler.net/problem=2.
     */
    private static final Problem problem1 = new Problem() {
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
    private static final Problem problem2 = new Problem() {
        private int fib(int n) {
            if (n <= 2) return n;
            else return fibIter(1, 1, n);
        }

        private int fibIter(int a, int b, int n) {
            if (n == 0) return a;
            else return fibIter(b, a + b, n - 1);
        }

        @Override
        public int solve() {
            int sum = 0;

            for (int n = 0; fib(n) <= 4000000; n++) {
                if (fib(n) % 2 == 0)
                    sum += fib(n);
            }

            return sum;
        }
    };

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
            field = Tester.class.getDeclaredField("problem" + num);
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

        System.out.println("Solution to problem " + num + ": " + problem.solve());
    }

}