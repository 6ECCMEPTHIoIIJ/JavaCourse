package edu.hw2;

public final class Expression1 extends ExpressionSystem {

    public Expression1(double a, double b) {
        super(
            new PartitionExpression() {
                public double evaluate(double[] values) {
                    if (values.length != 1) {
                        throw new IllegalArgumentException("Invalid number of arguments. Expected 1, but got %d".formatted(
                            values.length));
                    }

                    final double x = values[0];
                    if (x == 0) {
                        throw new IllegalArgumentException("Value under the logarithm equal to 0.0");
                    }

                    return b + 2 * Math.log(Math.abs(x));
                }

                public boolean checkCondition(double[] values) {
                    if (values.length != 1) {
                        throw new IllegalArgumentException("Invalid number of arguments. Expected 1, but got %d".formatted(
                            values.length));
                    }

                    final double x = values[0];
                    return x <= 3;
                }
            },
            new PartitionExpression() {
                public double evaluate(double[] values) {
                    if (values.length != 1) {
                        throw new IllegalArgumentException("Invalid number of arguments. Expected 1, but got %d".formatted(
                            values.length));
                    }

                    final double x = values[0];
                    final double xSqr = x * x;
                    if (xSqr + a == 0) {
                        throw new IllegalArgumentException("Denominator value equal to 0.0");
                    }

                    return xSqr / (xSqr + a);
                }

                public boolean checkCondition(double[] values) {
                    if (values.length != 1) {
                        throw new IllegalArgumentException("Invalid number of arguments. Expected 1, but got %d".formatted(
                            values.length));
                    }

                    final double x = values[0];
                    return x > 3;
                }
            }
        );
    }
}
