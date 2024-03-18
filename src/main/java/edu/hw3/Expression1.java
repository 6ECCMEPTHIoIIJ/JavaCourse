package edu.hw3;

public class Expression1 extends IntegralExpression {
    public Expression1() {
        super(
            () -> new IntegralElement(1) {
                @Override
                public double evaluate(double x) {
                    return Math.pow(-1.0, n)
                        * 2.0 * n * Math.pow(x, 2.0 * n + 1.0)
                        / MathUtils.factorial(2 * n + 1);
                }
            }
        );
    }
}

