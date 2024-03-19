package edu.hw3;

public class SumExpr5 extends SumExpr {
    protected SumExpr5() {
        super(
            0, 10,
            arg -> Math.pow(2.0, arg.n() / 2.0)
                * Math.sin(Math.PI * arg.n() / 4.0)
                * Math.pow(arg.x(), arg.n())
                / MathUtils.factorial(arg.n())
        );
    }

    @Override
    protected boolean checkBounds(double x) {
        return true;
    }
}
