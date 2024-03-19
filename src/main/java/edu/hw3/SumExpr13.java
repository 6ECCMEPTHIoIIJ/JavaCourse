package edu.hw3;

public class SumExpr13 extends SumExpr {
    protected SumExpr13() {
        super(
            1,
            arg -> Math.pow(-1.0, arg.n() + 1.0)
                * Math.pow(arg.x(), 2.0 * arg.n())
                / 2.0 / arg.n() / (2.0 * arg.n() - 1.0)
        );
    }

    @Override
    protected boolean checkBounds(double x) {
        return -1.0 <= x && x <= 1.0;
    }
}
