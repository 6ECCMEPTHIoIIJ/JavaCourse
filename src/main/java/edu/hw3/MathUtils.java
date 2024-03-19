package edu.hw3;

import java.util.function.Function;
import org.jetbrains.annotations.NotNull;

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
    public static double factorial(final int n) {
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
    public static double doubleFactorial(final int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative.");
        }

        double f = 1;
        for (int i = 2 + (n & 1); i <= n; i += 2) {
            f *= i;
        }
        return f;
    }

    /**
     * Compute the sum of a function over a range of integers.
     *
     * @param lower lower bound of the range
     * @param upper upper bound of the range
     * @param f     function to sum
     * @return sum of f(n) for n in [lower, upper]
     */
    public static double cumulate(
        final int lower,
        final int upper,
        final Function<@NotNull Integer, @NotNull Double> f
    ) {
        double sum = 0;
        for (int n = lower; n <= upper; n++) {
            sum += f.apply(n);
        }

        return sum;
    }

    /**
     * Compute the sum of a function over a range of integers.
     *
     * @param lower lower bound of the range
     * @param upper upper bound of the range
     * @param f     function to sum
     * @param x     parameter to pass to f
     * @return sum of f(x, n) for n in [lower, upper]
     */
    public static double cumulate(
        final int lower,
        final int upper,
        final Function<@NotNull SumEl, @NotNull Double> f,
        final double x
    ) {
        double sum = 0;
        for (int n = lower; n <= upper; n++) {
            sum += f.apply(SumEl.of(x, n));
        }

        return sum;
    }

    /**
     * Compute the sum of a function over a range of integers.
     *
     * @param lower     lower bound of the range
     * @param f         function to sum
     * @param x         parameter to pass to f
     * @param precision limit precision
     *                  of the range element value to calculate
     * @return sum of f(x, n) for n in [lower, ∞)
     */
    public static double cumulate(
        final int lower,
        final Function<@NotNull SumEl, @NotNull Double> f,
        final double x,
        final double precision
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
}
