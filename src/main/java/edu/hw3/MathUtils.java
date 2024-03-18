package edu.hw3;

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
     * Integrate an {@link IntegralElement} over a given argument.
     *
     * @param element the element to integrate
     * @param arg     the argument
     * @return the integral of the element over the argument
     */
    public static double integrate(
        final @NotNull IntegralElement element,
        final double arg
    ) {
        double sum = 0;
        double iteration;
        do {
            iteration = element.evaluate(arg);
            sum += iteration;
            element.next();
        } while (Math.abs(iteration) > Double.MIN_VALUE);

        return sum;
    }
}
