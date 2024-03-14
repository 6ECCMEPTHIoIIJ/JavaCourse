package edu.hw2;

/**
 * Class that evaluates the sixth expression.
 */
public final class Expression6 extends ExpressionSystem {

    /**
     * The edge that separates two partition expression conditions.
     */
    private static final double EXPRESSION_EDGE = -1.0;

    /**
     * Constructor for the sixth expression.
     *
     * @param a the value of the parameter a
     * @param b the value of the parameter b
     */
    public Expression6(final double a, final double b) {
        super(
            new PartitionExpression() {
                public double evaluate(final double value) {
                    final double xSqr = value * value;

                    return a * Math.tan(xSqr);
                }

                public boolean checkCondition(final double value) {
                    return value <= EXPRESSION_EDGE;
                }
            },
            new PartitionExpression() {
                public double evaluate(final double value) {
                    final double xSqr = value * value;
                    if (xSqr + a == 0) {
                        throw new DivisionByZeroException();
                    }

                    return b + xSqr / (xSqr + a);
                }

                public boolean checkCondition(final double value) {
                    return value > EXPRESSION_EDGE;
                }
            }
        );
    }
}

