package edu.hw3;

public class SumExpr3 extends SumExpr {
    protected SumExpr3() {
        super(
            0,
            arg -> Math.pow(arg.x(), 4.0 * arg.n() + 1.0)
                / (4.0 * arg.n() + 1.0)
        );
    }

    @Override
    protected boolean checkBounds(double x) {
        return -1.0 < x && x < 1.0;
    }
}
