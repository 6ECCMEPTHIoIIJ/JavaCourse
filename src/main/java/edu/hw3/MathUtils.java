package edu.hw3;

import java.util.function.Function;

public final class MathUtils {
    /**
     * Prevent instantiation.
     */
    private MathUtils() {
    }

    /**
     * Compute the factorial of a non-negative integer.
     *
     * @param n non-negative integer
     * @return n!
     */
    public static double factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative.");
        }

        double f = 1;
        for (int i = 2; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    /**
     * Compute the double factorial of a non-negative integer.
     *
     * @param n non-negative integer
     * @return n!!
     */
    public static double doubleFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative.");
        }

        double f = 1;
        for (int i = 2 + (n & 1); i <= n; i += 2) {
            f *= i;
        }
        return f;
    }

    public static double cumulate(
        int lower, int upper,
        Function<Integer, Double> f
    ) {
        double sum = 0;
        for (int n = lower; n <= upper; n++) {
            sum += f.apply(n);
        }

        return sum;
    }

    public static double cumulate(
        int lower, int upper,
        Function<SumEl, Double> f,
        double x
    ) {
        double sum = 0;
        for (int n = lower; n <= upper; n++) {
            sum += f.apply(SumEl.of(x, n));
        }

        return sum;
    }

    public static double cumulate(
        int lower,
        Function<SumEl, Double> f,
        double x,
        double precision
    ) {
        double sum = 0;
        int n = lower;
        boolean hasNext;
        do {
            double iter = f.apply(SumEl.of(x, n));
            hasNext = Math.abs(iter) > precision;
            sum += iter;
            n++;
        } while (hasNext);

        return sum;
    }

    public static double cumulate(
        int lower,
        Function<SumEl, Double> f,
        double x
    ) {
        return cumulate(lower, f, x, Double.MIN_VALUE);
    }
}
