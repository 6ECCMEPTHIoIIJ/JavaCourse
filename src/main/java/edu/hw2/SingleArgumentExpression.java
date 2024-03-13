package edu.hw2;

public interface SingleArgumentExpression extends Expression {
    double evaluate(final double value);

    @Override
    default double evaluate(double... values) {
        if (values.length != 1) {
            throw new InvalidNumberOfArgumentsException(
                1,
                values.length
            );
        }

        return evaluate(values[0]);
    }
}
