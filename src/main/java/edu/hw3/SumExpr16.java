package edu.hw3;

public final class SumExpr16 extends SumExpr {
    /**
     * The lower bound for the x value.
     */
    private static final double LOWER_X_BOUND = -1.0;

    /**
     * The upper bound for the x value.
     */
    private static final double UPPER_X_BOUND = 1.0;

    /**
     * The magic number const to suppress Magic Warning
     * (Attribute @SuppressWarning doesn't help).
     */
    private static final double MAGIC_NUMBER = 4.0;

    /**
     * The default constructor for SumExpr16.
     */
    public SumExpr16() {
        super(
            1,
            arg -> Math.pow(-1.0, arg.n() + 1.0)
                * Math.pow(arg.x(), 2.0 * arg.n() + 1.0)
                / (MAGIC_NUMBER * Math.pow(arg.n(), 2.0) - 1.0)
        );
    }

    @Override
    protected boolean checkBounds(final double x) {
        return LOWER_X_BOUND <= x && x <= UPPER_X_BOUND;
    }
}
