import java.lang.reflect.Field;

/**
 * A runner class to see the solutions to the ProjectEuler problems.
 * @author Aviv Shai
 * @author burgerhex
 * @version 1.0.11
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class Main {

    /**
     * The runner method for this class.
     * @param args arguments that don't make any difference
     * @see Main#printProblem(int) printProblem
     * @see Main#printProblems(int, int) printProblems
     */
    public static void main(String[] args) {
        printProblems(1, 11);
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
            int[] primes = new int[10001];
            primes[0] = 2;
            int added = 1;

            for (int i = 3; added < 10001; i += 2) {
                if (Helpers.isPrime(i)) {
                    primes[added] = i;
                    added++;
                }
            }

            return primes[10000];
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
     * Problem number 9 found at https://projecteuler.net/problem=9.
     */
    private static final Problem PROBLEM9 = new Problem() {
        @Override
        public long solve() {
            for (int a = 1; a < 1000; a++) {
                for (int b = 1; a + b + Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)) <= 1000; b++) {
                    double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

                    if ((int) c == c && a + b + (int) c == 1000) {
                        return a * b * (int) c;
                    }
                }
            }

            return 0;
        }
    };

    /**
     * Problem number 10 found at https://projecteuler.net/problem=10.
     */
    private static final Problem PROBLEM10 = new Problem() {
        @Override
        public long solve() {
            long sum = 2;

            for (int i = 3; i < 2000000; i += 2) {
                if (Helpers.isPrime(i))
                    sum += i;
            }

            return sum;
        }
    };

    /**
     * Problem number 11 found at https://projecteuler.net/problem=11.
     */
    private static final Problem PROBLEM11 = new Problem() {
        @Override
        public long solve() {
            String original =
                    "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08\n" +
                    "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00\n" +
                    "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65\n" +
                    "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91\n" +
                    "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80\n" +
                    "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50\n" +
                    "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70\n" +
                    "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21\n" +
                    "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72\n" +
                    "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95\n" +
                    "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92\n" +
                    "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57\n" +
                    "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58\n" +
                    "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40\n" +
                    "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66\n" +
                    "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69\n" +
                    "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36\n" +
                    "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16\n" +
                    "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54\n" +
                    "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";

            String[] lines = original.split("\n");
            int[][] grid = new int[lines.length][lines.length];

            for (int i = 0; i < lines.length; i++) {
                String[] nums = lines[i].split(" ");
                int[] temp = new int[lines.length];

                for (int j = 0; j < nums.length; j++) {
                    temp[j] = Integer.valueOf(nums[j]);
                }

                grid[i] = temp;
            }

            long horizMax = 0;
            long vertMax  = 0;
            long diagLMax = 0; // top left to bottom right
            long diagRMax = 0; // top right to bottom left

            for (int i = 0; i < grid.length - 3; i++) {
                for (int j = 0; j < grid[i].length - 3; j++) {
                    long horizProd = grid[i][j] * grid[i][j + 1] * grid[i][j + 2] * grid[i][j + 3];
                    long vertProd  = grid[i][j] * grid[i + 1][j] * grid[i + 2][j] * grid[i + 3][j];
                    long diagLProd = grid[i][j] * grid[i + 1][j + 1] * grid[i + 2][j + 2] * grid[i + 3][j + 3];
                    long diagRProd = grid[i + 3][j] * grid[i + 2][j + 1] * grid[i + 1][j + 2] * grid[i][j + 3];

                    if (horizProd > horizMax) horizMax = horizProd;
                    if (vertProd  > vertMax)  vertMax  = vertProd;
                    if (diagLProd > diagLMax) diagLMax = diagLProd;
                    if (diagRProd > diagRMax) diagRMax = diagRProd;
                }
            }

            return Math.max(Math.max(horizMax, vertMax), Math.max(diagLMax, diagRMax));

        }
    };

    /**
     * Prints the solutions to multiple problems from this class.
     * @param first the number of the first problem to print
     * @param last the number of the last problem to print
     * @see Main#printProblem(int) printProblem
     */
    private static void printProblems(int first, int last) {
        long startTime = System.nanoTime();

        for (int i = first; i <= last; i++) {
            printProblem(i);
        }

        long endTime = System.nanoTime();

        double seconds = (endTime - startTime) / 1000000000.0;

        System.out.format("Total time: %.3f seconds", seconds);
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
