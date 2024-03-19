package edu.hw3;

public final class SumExpr6 extends SumExpr {
    /**
     * The default constructor for SumExpr6.
     */
    public SumExpr6() {
        super(
            2,
            arg -> Math.pow(-1.0, arg.n() + 1.0)
                * (arg.n() - 1.0) * Math.pow(arg.x(), arg.n())
                / MathUtils.factorial(arg.n())
        );
    }

    @Override
    public double evaluate(final double x, final double precision) {
        return 1.0 + super.evaluate(x, precision);
    }

    @Override
    protected boolean checkBounds(final double x) {
        return true;
    }
}
