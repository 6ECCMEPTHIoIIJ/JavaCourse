package edu.hw3;

public class SumExpr12 extends SumExpr {
    protected SumExpr12() {
        super(
            1,
            arg -> Math.pow(-1.0, arg.n())
                * Math.pow(2.0, 2.0 * arg.n() - 1.0)
                * Math.pow(arg.x(), 2.0 * arg.n() - 1.0)
                / (2.0 * arg.n() - 1.0)
        );
    }

    @Override
    public double evaluate(double x, double precision) {
        return Math.atan(2.0) + super.evaluate(x, precision);
    }

    @Override
    protected boolean checkBounds(double x) {
        return -1.0 / 4.0 < x && x <= 1.0 / 2.0;
    }
}
