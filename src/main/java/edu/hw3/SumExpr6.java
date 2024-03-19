package edu.hw3;

public class SumExpr6 extends SumExpr {
    protected SumExpr6() {
        super(
            2,
            arg -> Math.pow(-1.0, arg.n() + 1.0)
                * (arg.n() - 1.0) * Math.pow(arg.x(), arg.n())
                / MathUtils.factorial(arg.n())
        );
    }

    @Override
    public double evaluate(double x, double precision) {
        return 1.0 + super.evaluate(x, precision);
    }

    @Override
    protected boolean checkBounds(double x) {
        return true;
    }
}
