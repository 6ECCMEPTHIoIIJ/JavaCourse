package edu.hw3;

public class SumExpr14 extends SumExpr {
    protected SumExpr14() {
        super(
            0,
            arg -> Math.pow(-1.0, arg.n())
                * Math.pow(arg.x(), 2.0 * arg.n() + 1.0)
                * (1.0 + Math.pow(arg.x(), 2.0))
                / (2.0 * arg.n() + 1.0)
        );
    }

    @Override
    protected boolean checkBounds(double x) {
        return -1.0 <= x && x <= 1.0;
    }
}
