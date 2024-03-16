package edu.hw2;

/**
 * Class that evaluates the eleventh expression.
 */
public final class Expression11 extends ExpressionSystem {
    /**
     * The edge that separates two partition expression conditions.
     */
    private static final double EXPRESSION_EDGE = 4.0;

    /**
     * Constructor for the eleventh expression.
     *
     * @param a the value of the parameter a
     * @param b the value of the parameter b
     */
    public Expression11(final double a, final double b) {
        super(new PartitionExpression() {
            public double evaluate(final double value) {
                final double absSinX = Math.abs(Math.sin((value)));
                if (a + absSinX < 0) {
                    throw new ArithmeticException(
                        "Negative value under the square root"
                    );
                }

                return Math.sqrt(a + absSinX);
            }

            public boolean checkCondition(final double value) {
                return value > EXPRESSION_EDGE;
            }
        }, new PartitionExpression() {
            public double evaluate(final double value) {
                return Math.tan(b * value);
            }

            public boolean checkCondition(final double value) {
                return value <= EXPRESSION_EDGE;
            }
        });
    }
}
