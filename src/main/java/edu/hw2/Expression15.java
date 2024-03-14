package edu.hw2;

/**
 * Class that evaluates the fifteenth expression.
 */
public final class Expression15 extends ExpressionSystem {
    /**
     * The edge that separates two partition expression conditions.
     */
    private static final double EXPRESSION_EDGE = 2.0;

    /**
     * Constructor for the fifteenth expression.
     *
     * @param a the value of the parameter a
     * @param b the value of the parameter b
     */
    public Expression15(final double a, final double b) {
        super(new PartitionExpression() {
            public double evaluate(final double value) {
                return Math.sin(value + a * a);
            }

            public boolean checkCondition(final double value) {
                return value < EXPRESSION_EDGE;
            }
        }, new PartitionExpression() {
            public double evaluate(final double value) {
                final double logValue = value * value + 2.0 * value + b;
                if (logValue <= 0) {
                    throw new IllegalArgumentException(
                        "Value under the logarithm below or equal to 0.0"
                    );
                }

                return Math.log(logValue);
            }

            public boolean checkCondition(final double value) {
                return value >= EXPRESSION_EDGE;
            }
        });
    }
}
