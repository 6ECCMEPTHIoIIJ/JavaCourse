package edu.hw2;

/**
 * Class that evaluates the seventh expression.
 */
public final class Expression7 extends ExpressionSystem {

    /**
     * The edge that separates two partition expression conditions.
     */
    private static final double EXPRESSION_EDGE = 3.0;

    /**
     * Constructor for the seventh expression.
     *
     * @param a the value of the parameter a
     * @param b the value of the parameter b
     */
    public Expression7(final double a, final double b) {
        super(
            new PartitionExpression() {
                public double evaluate(final double value) {
                    return (a + value) * Math.atan(a * value);
                }

                public boolean checkCondition(final double value) {
                    return value > EXPRESSION_EDGE;
                }
            },
            new PartitionExpression() {
                public double evaluate(final double value) {
                    return Math.pow(Math.cos(b + value * value * value), 2);
                }

                public boolean checkCondition(final double value) {
                    return value <= EXPRESSION_EDGE;
                }
            }
        );
    }
}
