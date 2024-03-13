package edu.hw2;

public class ExpressionFactory {
    private final int expression;

    public ExpressionFactory(final int expressionNumber) {
        expression = expressionNumber;
    }

    public Expression createExpression(final double a, final double b) {
        switch (expression) {
            case 1:
                return new Expression1(a, b);
            case 2:
                return new Expression2(a, b);
            default:
                throw new IllegalArgumentException("Invalid expression number: " + expression);
        }
    }
}
