package edu.hw2;

/**
 * Class that evaluates the fourteenth expression.
 */
public final class Expression14 extends ExpressionSystem {
    /**
     * Constant to suppress MagicNumber warning.
     * It`s really a magic number :)
     */
    private static final double EXPRESSION_14_MAGIC_CONST_1 = 0.2;

    /**
     * Constant to suppress MagicNumber warning.
     * It`s really a magic number :)
     */
    private static final double EXPRESSION_14_MAGIC_CONST_2 = 3.0;

    /**
     * The edge that separates two partition expression conditions.
     */
    private static final double EXPRESSION_EDGE = -1.0;

    /**
     * Constructor for the fourteenth expression.
     *
     * @param a the value of the parameter a
     * @param b the value of the parameter b
     */
    public Expression14(final double a, final double b) {
        super(new PartitionExpression() {
            public double evaluate(final double value) {
                return EXPRESSION_14_MAGIC_CONST_1 * value * value * value + a;
            }

            public boolean checkCondition(final double value) {
                return value > EXPRESSION_EDGE;
            }
        }, new PartitionExpression() {
            public double evaluate(final double value) {
                if (value + EXPRESSION_14_MAGIC_CONST_2 == 0.0) {
                    throw new ArithmeticException(
                        "Value under the logarithm equal to 0.0"
                    );
                }

                return b * value * value
                    + Math.log(Math.abs(value + EXPRESSION_14_MAGIC_CONST_2));
            }

            public boolean checkCondition(final double value) {
                return value <= EXPRESSION_EDGE;
            }
        });
    }
}
