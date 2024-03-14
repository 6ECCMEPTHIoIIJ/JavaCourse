package edu.hw2;

/**
 * Interface for partition expressions.
 */
public interface PartitionExpression extends Expression {
    /**
     * Check the condition if part of expression
     * can be evaluated for the given value.
     *
     * @param value value to check the condition for
     * @return true if the condition is met, false otherwise
     */
    boolean checkCondition(double value);
}
