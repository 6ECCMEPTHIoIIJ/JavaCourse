package edu.hw2;

/**
 * An expression system that can evaluate multiple partial expressions.
 */
public class ExpressionSystem implements Expression {
    /**
     * The partial expressions to use.
     */
    private final PartitionExpression[] expressions;

    /**
     * Create a new expression system with the given partial expressions.
     *
     * @param partitionExpressions the expressions to use
     */
    public ExpressionSystem(final PartitionExpression... partitionExpressions) {
        expressions = partitionExpressions;
    }

    /**
     * Evaluate the expression system for the given value.
     *
     * @param value value to evaluate the expression system for
     * @return the result of the evaluation
     * @throws NoValidExpressionConditionException if no system expression`s
     *                                             condition is valid
     */
    @Override
    public double evaluate(final double value) {
        for (PartitionExpression expression : expressions) {
            if (expression.checkCondition(value)) {
                return expression.evaluate(value);
            }
        }

        throw new NoValidExpressionConditionException();
    }
}

