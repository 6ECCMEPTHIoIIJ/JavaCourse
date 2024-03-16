package edu.hw2;

/**
 * Class that evaluates the thirteenth expression.
 */
public final class Expression13 extends ExpressionSystem {
    /**
     * The edge that separates two partition expression conditions.
     */
    private static final double EXPRESSION_EDGE = 2.0;

    /**
     * Constructor for the thirteenth expression.
     *
     * @param a the value of the parameter a
     * @param b the value of the parameter b
     */
    public Expression13(final double a, final double b) {
        super(new PartitionExpression() {
            public double evaluate(final double value) {
                final double xSqr = value * value;
                if (a + xSqr <= 0) {
                    throw new ArithmeticException(
                        "Value under the logarithm below or equal to 0.0"
                    );
                }

                return Math.log(a + xSqr);
            }

            public boolean checkCondition(final double value) {
                return value >= EXPRESSION_EDGE;
            }
        }, new PartitionExpression() {
            public double evaluate(final double value) {
                return Math.exp(Math.sin(value)) + 2.0 * b;
            }

            public boolean checkCondition(final double value) {
                return value < EXPRESSION_EDGE;
            }
        });
    }
}
