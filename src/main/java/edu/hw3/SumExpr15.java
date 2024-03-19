package edu.hw3;

public class SumExpr15 extends SumExpr {
    protected SumExpr15() {
        super(
            1,
            arg -> Math.pow(-1.0, arg.n() - 1.0)
                * Math.pow(arg.x(), arg.n())
                * (1.0 + arg.x())
                / arg.n()
        );
    }

    @Override
    protected boolean checkBounds(double x) {
        return -1.0 <= x && x <= 1.0;
    }
}
