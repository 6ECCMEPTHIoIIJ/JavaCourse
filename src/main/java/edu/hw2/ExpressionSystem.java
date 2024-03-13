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
     * Evaluate the expression system for the given values.
     *
     * @param values the array of values to evaluate the expression system for
     * @return the result of the evaluation
     * @throws NoValidExpressionConditionException if no system expression`s
     *                                             condition is valid
     */
    @Override
    public double evaluate(final double... values) {
        for (PartitionExpression expression : expressions) {
            if (expression.checkCondition(values)) {
                return expression.evaluate(values);
            }
        }

        throw new NoValidExpressionConditionException();
    }
}

