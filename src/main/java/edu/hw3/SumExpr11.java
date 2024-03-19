package edu.hw3;

public final class SumExpr11 extends SumExpr {
    /**
     * The lower bound for the x value.
     */
    private static final double LOWER_X_BOUND = -1.0;

    /**
     * The upper bound for the x value.
     */
    private static final double UPPER_X_BOUND = 1.0;

    /**
     * The default constructor for SumExpr11.
     */
    public SumExpr11() {
        super(
            0,
            arg -> MathUtils.doubleFactorial(2 * arg.n() + 1)
                * Math.pow(arg.x(), 2.0 * arg.n())
                / MathUtils.doubleFactorial(2 * arg.n())
        );
    }

    @Override
    protected boolean checkBounds(final double x) {
        return LOWER_X_BOUND < x && x < UPPER_X_BOUND;
    }
}