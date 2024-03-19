package edu.hw3;

import java.util.function.Function;

public abstract class SumExpr {
    private final int lower;
    private final Integer upper;
    private final Function<SumEl, Double> f;

    protected SumExpr(int lower, int upper, Function<SumEl, Double> f) {
        this.lower = lower;
        this.f = f;
        this.upper = upper;
    }

    protected SumExpr(int lower, Function<SumEl, Double> f) {
        this.lower = lower;
        this.f = f;
        this.upper = null;
    }

    public double evaluate(double x, double precision) {
        if (!checkBounds(x)) {
            throw new IllegalArgumentException("x is out of bounds.");
        }

        return upper != null
            ? MathUtils.cumulate(lower, upper, f, x)
            : MathUtils.cumulate(lower, f, x, precision);
    }

    public final double evaluate(double x) {
        return evaluate(x, Double.MIN_VALUE);
    }

    protected abstract boolean checkBounds(double x);
}
