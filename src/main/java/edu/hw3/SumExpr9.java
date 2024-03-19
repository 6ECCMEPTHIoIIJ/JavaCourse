package edu.hw3;

public final class SumExpr9 extends SumExpr {
    /**
     * The lower bound for the x value.
     */
    private static final double LOWER_X_BOUND = -1.0;

    /**
     * The upper bound for the x value.
     */
    private static final double UPPER_X_BOUND = 1.0;

    /**
     * The default constructor for SumExpr9.
     */
    public SumExpr9() {
        super(
            1,
            arg -> MathUtils.cumulate(1, arg.n(), n -> 1.0 / n)
                * Math.pow(arg.x(), arg.n() + 1.0)
                / (arg.n() + 1.0)
        );
    }

    @Override
    public double evaluate(final double x, final double precision) {
        return 2.0 * super.evaluate(x, precision);
    }

    @Override
    protected boolean checkBounds(final double x) {
        return LOWER_X_BOUND <= x && x < UPPER_X_BOUND;
    }
}
