package edu.hw3;

public final class SumExpr15 extends SumExpr {
    /**
     * The lower bound for the x value.
     */
    private static final double LOWER_X_BOUND = -1.0;

    /**
     * The upper bound for the x value.
     */
    private static final double UPPER_X_BOUND = 1.0;

    /**
     * The default constructor for SumExpr15.
     */
    public SumExpr15() {
        super(
            1,
            arg -> Math.pow(-1.0, arg.n() - 1.0)
                * Math.pow(arg.x(), arg.n())
                * (1.0 + arg.x())
                / arg.n()
        );
    }

    @Override
    protected boolean checkBounds(final double x) {
        return LOWER_X_BOUND <= x && x <= UPPER_X_BOUND;
    }

}
