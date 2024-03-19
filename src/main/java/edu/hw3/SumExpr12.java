package edu.hw3;

public final class SumExpr12 extends SumExpr {
    /**
     * The lower bound for the x value.
     */
    private static final double LOWER_X_BOUND = -1.0 / 4.0;

    /**
     * The upper bound for the x value.
     */
    private static final double UPPER_X_BOUND = 1.0 / 2.0;

    /**
     * The default constructor for SumExpr12.
     */
    public SumExpr12() {
        super(
            1,
            arg -> Math.pow(-1.0, arg.n())
                * Math.pow(2.0, 2.0 * arg.n() - 1.0)
                * Math.pow(arg.x(), 2.0 * arg.n() - 1.0)
                / (2.0 * arg.n() - 1.0)
        );
    }

    @Override
    public double evaluate(final double x, final double precision) {
        return Math.atan(2.0) + super.evaluate(x, precision);
    }

    @Override
    protected boolean checkBounds(final double x) {
        return LOWER_X_BOUND < x && x <= UPPER_X_BOUND;
    }
}
