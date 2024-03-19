package edu.hw3;

public class SumExpr1 extends SumExpr {
    protected SumExpr1() {
        super(
            1,
            arg -> Math.pow(-1.0, arg.n())
                * 2.0 * arg.n() * Math.pow(arg.x(), 2.0 * arg.n() + 1.0)
                / MathUtils.factorial(2 * arg.n() + 1)
        );
    }

    @Override
    protected boolean checkBounds(double x) {
        return true;
    }
}
