package edu.hw2;

public interface SingleArgumentPartitionExpression
    extends SingleArgumentExpression, PartitionExpression {
    boolean checkCondition(double value);

    @Override
    default boolean checkCondition(double... values) {
        if (values.length != 1) {
            throw new InvalidNumberOfArgumentsException(
                1,
                values.length
            );
        }

        return checkCondition(values[0]);
    }
}
