package edu.hw2;

/**
 * An expression system that can evaluate multiple partial expressions.
 */
public class ExpressionSystem implements Expression {
    private final PartitionExpression[] expressions;

    /**
     * Create a new expression system with the given partial expressions.
     *
     * @param expressions the expressions to use
     */
    public ExpressionSystem(PartitionExpression... expressions) {
        this.expressions = expressions;
    }

    /**
     * Evaluate the expression system for the given values.
     *
     * @param values the array of values to evaluate the expression system for
     * @return the result of the evaluation
     * @throws IllegalStateException if no system expression`s condition is valid
     */
    @Override
    public double evaluate(double[] values) {
        for (PartitionExpression expression : expressions) {
            if (expression.checkCondition(values)) {
                return expression.evaluate(values);
            }
        }

        throw new IllegalStateException("No system expression`s condition is valid");
    }
}
