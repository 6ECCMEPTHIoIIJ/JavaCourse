package edu.hw2;

/**
 * Class that evaluates the third expression.
 */
public final class Expression3 extends ExpressionSystem {

    /**
     * The edge that separates two partition expression conditions.
     */
    private static final double EXPRESSION_EDGE = 1.0;

    /**
     * Constructor for the third expression.
     *
     * @param a the value of the parameter a
     * @param b the value of the parameter b
     */
    public Expression3(final double a, final double b) {
        super(
            new PartitionExpression() {
                public double evaluate(final double value) {
                    final double denominator = value * value + a * a;
                    if (denominator == 0) {
                        throw new DivisionByZeroException();
                    }

                    return 1.0 / denominator;
                }

                public boolean checkCondition(final double value) {
                    return value <= EXPRESSION_EDGE;
                }
            },
            new PartitionExpression() {
                public double evaluate(final double value) {
                    return b * Math.log(Math.abs(value));
                }

                public boolean checkCondition(final double value) {
                    return value > EXPRESSION_EDGE;
                }
            }
        );
    }
}


