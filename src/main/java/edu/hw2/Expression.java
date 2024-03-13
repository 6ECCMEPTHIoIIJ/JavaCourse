package edu.hw2;

public interface Expression {
    /**
     * Evaluate the expression for the given values.
     *
     * @param values the array of values to evaluate the expression for
     * @return the result of the evaluation
     */
    double evaluate(double[] values);
}
