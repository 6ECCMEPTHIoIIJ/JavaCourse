package edu.hw3;

public class SumExpr10 extends SumExpr {
    protected SumExpr10() {
        super(
            1,
            arg -> Math.pow(-1.0, arg.n() - 1.0)
                * MathUtils.cumulate(1, arg.n(), n -> 1.0 / n)
                * Math.pow(arg.x(), arg.n())
        );
    }

    @Override
    protected boolean checkBounds(double x) {
        return -1.0 < x && x < 1.0;
    }
}
