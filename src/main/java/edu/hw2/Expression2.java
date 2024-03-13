package edu.hw2;

/**
 * Class that evaluates the second expression.
 */
public final class Expression2 extends ExpressionSystem {

    /**
     * The edge that separates two partition expression conditions.
     */
    private static final double EXPRESSION_EDGE = 0.0;

    /**
     * Constructor for the second expression.
     *
     * @param a the value of the parameter a
     * @param b the value of the parameter b
     */
    public Expression2(final double a, final double b) {
        super(
            new SingleArgumentPartitionExpression() {
                public double evaluate(final double value) {
                    return a + Math.exp(-value) / 2.0;
                }

                public boolean checkCondition(final double value) {
                    return value > EXPRESSION_EDGE;
                }
            },
            new SingleArgumentPartitionExpression() {
                public double evaluate(final double value) {
                    return Math.cos(b * value + 1.0);
                }

                public boolean checkCondition(final double value) {
                    return value <= EXPRESSION_EDGE;
                }
            }
        );
    }
}

