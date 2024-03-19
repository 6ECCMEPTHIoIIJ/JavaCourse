package edu.hw3;

public class SumExpr9 extends SumExpr {
    protected SumExpr9() {
        super(
            1,
            arg -> MathUtils.cumulate(1, arg.n(), n -> 1.0 / n)
                * Math.pow(arg.x(), arg.n() + 1.0)
                / (arg.n() + 1.0)
        );
    }

    @Override
    public double evaluate(double x, double precision) {
        return 2.0 * super.evaluate(x, precision);
    }

    @Override
    protected boolean checkBounds(double x) {
        return -1.0 <= x && x < 1.0;
    }
}
