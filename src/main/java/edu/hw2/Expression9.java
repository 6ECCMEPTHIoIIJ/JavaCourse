package edu.hw2;

/**
 * Class that evaluates the ninth expression.
 */
public final class Expression9 extends ExpressionSystem {

    /**
     * Constant to suppress MagicNumber warning.
     * It`s really a magic number :)
     */
    private static final double EXPRESSION_9_MAGIC_CONST = 3.0;

    /**
     * The edge that separates two partition expression conditions.
     */
    private static final double EXPRESSION_EDGE = 2.0;

    /**
     * Constructor for the ninth expression.
     *
     * @param a the value of the parameter a
     * @param b the value of the parameter b
     */
    public Expression9(final double a, final double b) {
        super(new PartitionExpression() {
            public double evaluate(final double value) {
                return Math.sqrt(1.0 + value * Math.sqrt(a * value));
            }

            public boolean checkCondition(final double value) {
                return value >= EXPRESSION_EDGE;
            }
        }, new PartitionExpression() {
            public double evaluate(final double value) {
                return a * Math.sin(b * value) + EXPRESSION_9_MAGIC_CONST;
            }

            public boolean checkCondition(final double value) {
                return value < EXPRESSION_EDGE;
            }
        });
    }
}
