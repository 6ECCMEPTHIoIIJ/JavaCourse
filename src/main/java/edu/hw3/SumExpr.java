package edu.hw3;

import java.util.function.Function;
import org.jetbrains.annotations.NotNull;

public abstract class SumExpr {
    /**
     * Lower bound of the sum.
     */
    private final int lower;
    /**
     * Upper bound of the sum.
     */
    private final Integer upper;
    /**
     * Function to sum.
     */
    private final Function<@NotNull SumEl, @NotNull Double> f;

    /**
     * Constructor for SumExpr.
     *
     * @param lowerBound lower bound of the sum
     * @param upperBound upper bound of the sum
     * @param function   function to sum
     */
    protected SumExpr(
        final int lowerBound,
        final int upperBound,
        final Function<@NotNull SumEl, @NotNull Double> function
    ) {
        lower = lowerBound;
        upper = upperBound;
        f = function;
    }

    /**
     * Constructor for SumExpr.
     *
     * @param lowerBound lower bound of the sum
     * @param function   function to sum
     */
    protected SumExpr(
        final int lowerBound,
        final Function<@NotNull SumEl, @NotNull Double> function
    ) {
        lower = lowerBound;
        upper = null;
        f = function;
    }

    /**
     * Evaluate the sum of the function.
     *
     * @param x         the x value
     * @param precision the precision
     * @return the sum of the function
     */
    public double evaluate(final double x, final double precision) {
        if (!checkBounds(x)) {
            throw new IllegalArgumentException("x is out of bounds.");
        }

        return upper != null
            ? MathUtils.cumulate(lower, upper, f, x)
            : MathUtils.cumulate(lower, f, x, precision);
    }

    /**
     * Check if the x value is within the bounds.
     *
     * @param x the x value
     * @return true if x is within the bounds, false otherwise
     */
    protected abstract boolean checkBounds(double x);
}
