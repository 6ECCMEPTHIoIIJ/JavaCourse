package edu.hw2;

/**
 * Class that evaluates the tenth expression.
 */
public final class Expression10 extends ExpressionSystem {
    /**
     * The edge that separates two partition expression conditions.
     */
    private static final double EXPRESSION_EDGE = 0.0;

    /**
     * Constructor for the tenth expression.
     *
     * @param a the value of the parameter a
     * @param b the value of the parameter b
     */
    public Expression10(final double a, final double b) {
        super(new PartitionExpression() {
            public double evaluate(final double value) {
                return Math.sqrt(Math.exp(2.0 * value - b) - 1.0);
            }

            public boolean checkCondition(final double value) {
                return value <= EXPRESSION_EDGE;
            }
        }, new PartitionExpression() {
            public double evaluate(final double value) {
                final double denominator = value * value + a;
                if (denominator == 0) {
                    throw new DivisionByZeroException();
                }

                return 1.0 / denominator;
            }

            public boolean checkCondition(final double value) {
                return value > EXPRESSION_EDGE;
            }
        });
    }
}

