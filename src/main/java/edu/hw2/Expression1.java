package edu.hw2;

/**
 * Class that evaluates the first expression.
 */
public final class Expression1 extends ExpressionSystem {

    /**
     * The edge that separates two partition expression conditions.
     */
    private static final double EXPRESSION_EDGE = 3.0;

    /**
     * Constructor for the first expression.
     *
     * @param a the value of the parameter a
     * @param b the value of the parameter b
     */
    public Expression1(final double a, final double b) {
        super(
            new PartitionExpression() {
                public double evaluate(final double value) {
                    if (value == 0) {
                        throw new ArithmeticException(
                            "Value under the logarithm equal to 0.0"
                        );
                    }

                    return b + 2 * Math.log(Math.abs(value));
                }

                public boolean checkCondition(final double value) {
                    return value <= EXPRESSION_EDGE;
                }
            },
            new PartitionExpression() {
                public double evaluate(final double value) {
                    final double xSqr = value * value;
                    final double denominator = xSqr + a;
                    if (denominator == 0) {
                        throw new DivisionByZeroException();
                    }

                    return xSqr / denominator;
                }

                public boolean checkCondition(final double value) {
                    return value > EXPRESSION_EDGE;
                }
            }
        );
    }

}

