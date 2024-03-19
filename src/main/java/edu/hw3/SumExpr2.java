package edu.hw3;

public class SumExpr2 extends SumExpr {
    protected SumExpr2() {
        super(
            0,
            arg -> Math.pow(arg.x(), 2.0 * arg.n() + 1.0)
                / (2.0 * arg.n() + 1.0)
        );
    }

    @Override
    protected boolean checkBounds(double x) {
        return -1.0 < x && x < 1.0;
    }
}
