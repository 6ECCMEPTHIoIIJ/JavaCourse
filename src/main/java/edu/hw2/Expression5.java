package edu.hw2;

/**
 * Class that evaluates the fifth expression.
 */
public final class Expression5 extends ExpressionSystem {

    /**
     * The edge that separates two partition expression conditions.
     */
    private static final double EXPRESSION_EDGE = 1.0;

    /**
     * Constructor for the fifth expression.
     *
     * @param a the value of the parameter a
     * @param b the value of the parameter b
     */
    public Expression5(final double a, final double b) {
        super(
            new PartitionExpression() {
                public double evaluate(final double value) {
                    if (value < 0) {
                        throw new ArithmeticException(
                            "Value under the square root is negative"
                        );
                    }

                    return a * Math.pow(Math.sin(value), 2) + Math.sqrt(value);
                }

                public boolean checkCondition(final double value) {
                    return value <= EXPRESSION_EDGE;
                }
            },
            new PartitionExpression() {
                public double evaluate(final double value) {
                    return b * Math.exp(value * value);
                }

                public boolean checkCondition(final double value) {
                    return value > EXPRESSION_EDGE;
                }
            }
        );
    }
}
