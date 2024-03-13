package edu.hw2;

/**
 * Interface for expressions.
 */
public interface Expression {
    /**
     * Evaluate the expression for the given values.
     *
     * @param values values to evaluate the expression for
     * @return the result of the evaluation
     */
    double evaluate(double... values);
}
