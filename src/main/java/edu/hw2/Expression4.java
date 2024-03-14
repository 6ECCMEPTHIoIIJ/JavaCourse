package edu.hw2;

/**
 * Class that evaluates the fourth expression.
 */
public final class Expression4 extends ExpressionSystem {

    /**
     * The edge that separates two partition expression conditions.
     */
    private static final double EXPRESSION_EDGE = 2.0;

    /**
     * Constructor for the fourth expression.
     *
     * @param a the value of the parameter a
     * @param b the value of the parameter b
     */
    public Expression4(final double a, final double b) {
        super(
            new PartitionExpression() {
                public double evaluate(final double value) {
                    final double denominator = b
                        + Math.log(Math.abs(value) + 1);
                    if (denominator == 0) {
                        throw new DivisionByZeroException();
                    }

                    return (a + value * value) / denominator;
                }

                public boolean checkCondition(final double value) {
                    return value <= EXPRESSION_EDGE;
                }
            },
            new PartitionExpression() {
                public double evaluate(final double value) {
                    return Math.exp(value) + value * value;
                }

                public boolean checkCondition(final double value) {
                    return value > EXPRESSION_EDGE;
                }
            }
        );
    }
}

