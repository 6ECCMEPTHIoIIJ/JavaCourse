package edu.hw3;

public class Expression2 extends IntegralExpression {
    public Expression2() {
        super(
            () -> new IntegralElement(0) {
                @Override
                public double evaluate(double x) {
                    return Math.pow(x, 2.0 * n + 1.0)
                        / (2 * n + 1);
                }
            },
            new IntegralExpressionArgBoundsChecker(
                new Bounds(-1, 1)
            ) {
            }
        );
    }
}
