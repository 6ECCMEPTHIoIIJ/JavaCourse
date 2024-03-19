package edu.hw3;

public final class SumExpr4 extends SumExpr {
    /**
     * The magic number const to suppress Magic Warning
     * (Attribute @SuppressWarning doesn't help).
     */
    private static final double MAGIC_NUMBER = 4.0;

    /**
     * The upper bound for the n value.
     */
    private static final int UPPER_N_BOUND = 10;

    /**
     * The default constructor for SumExpr4.
     */
    public SumExpr4() {
        super(
            0, UPPER_N_BOUND,
            arg -> Math.pow(2.0, arg.n() / 2.0)
                * Math.cos(Math.PI * arg.n() / MAGIC_NUMBER)
                * Math.pow(arg.x(), arg.n())
                / MathUtils.factorial(arg.n())
        );
    }

    @Override
    protected boolean checkBounds(final double x) {
        return true;
    }
}
