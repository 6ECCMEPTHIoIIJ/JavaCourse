package edu.hw2;

/**
 * Class that evaluates the twelfth expression.
 */
public final class Expression12 extends ExpressionSystem {
    /**
     * Constant to suppress MagicNumber warning.
     * It`s really a magic number :)
     */
    private static final double EXPRESSION_12_MAGIC_CONST = 3.0;

    /**
     * The edge that separates two partition expression conditions.
     */
    private static final double EXPRESSION_EDGE = 1.0;

    /**
     * Constructor for the twelfth expression.
     *
     * @param a the value of the parameter a
     * @param b the value of the parameter b
     */
    public Expression12(final double a, final double b) {
        super(new PartitionExpression() {
            public double evaluate(final double value) {
                return 2.0 * value * value + a * Math.cos(b * value);
            }

            public boolean checkCondition(final double value) {
                return value <= EXPRESSION_EDGE;
            }
        }, new PartitionExpression() {
            public double evaluate(final double value) {
                return Math.exp(value)
                    + Math.tan(Math.pow(value, EXPRESSION_12_MAGIC_CONST));
            }

            public boolean checkCondition(final double value) {
                return value > EXPRESSION_EDGE;
            }
        });
    }
}
