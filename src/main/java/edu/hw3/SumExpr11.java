package edu.hw3;

public class SumExpr11 extends SumExpr {
    protected SumExpr11() {
        super(
            0,
            arg -> MathUtils.doubleFactorial(2 * arg.n() + 1)
                * Math.pow(arg.x(), 2.0 * arg.n())
                / MathUtils.doubleFactorial(2 * arg.n())
        );
    }

    @Override
    protected boolean checkBounds(double x) {
        return -1.0 < x && x < 1.0;
    }
}
