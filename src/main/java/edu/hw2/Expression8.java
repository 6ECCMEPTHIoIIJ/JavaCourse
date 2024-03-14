package edu.hw2;

/**
 * Class that evaluates the eighth expression.
 */
public final class Expression8 extends ExpressionSystem {

    /**
     * The edge that separates two partition expression conditions.
     */
    private static final double EXPRESSION_EDGE = 5.0;

    /**
     * Constant to suppress MagicNumber warning.
     * It`s really a magic number :)
     */
    private static final double EXPRESSION_8_MAGIC_CONST = 3.0;

    /**
     * Constructor for the eighth expression.
     *
     * @param a the value of the parameter a
     * @param b the value of the parameter b
     */
    public Expression8(final double a, final double b) {
        super(
            new PartitionExpression() {
                public double evaluate(final double value) {
                    return Math.pow(
                        Math.sin(a + value),
                        EXPRESSION_8_MAGIC_CONST
                    );
                }

                public boolean checkCondition(final double value) {
                    return value < EXPRESSION_EDGE;
                }
            },
            new PartitionExpression() {
                public double evaluate(final double value) {
                    if (b - value == 0) {
                        throw new IllegalArgumentException(
                            "Value under the logarithm equal to 0.0"
                        );
                    }

                    return Math.log(Math.sqrt(Math.abs(b - value)));
                }

                public boolean checkCondition(final double value) {
                    return value >= EXPRESSION_EDGE;
                }
            }
        );
    }
}
