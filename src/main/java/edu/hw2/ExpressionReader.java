package edu.hw2;

public abstract class ExpressionReader {

    /**
     * The reader of expression parameters.
     */
    private final ParameterReader parameterReader = new ParameterReader();
    /**
     * The expression factory to use.
     */
    private final ExpressionFactory factory;

    /**
     * Create a new expression reader for expressions with two parameters.
     *
     * @param expressionFactory the expression factory to use
     */
    public ExpressionReader(
        final ExpressionFactory expressionFactory
    ) {
        factory = expressionFactory;
    }

    /**
     * Read the expression parameters from the console.
     *
     * @return the expression
     */
    public Expression readExpression() {
        final double a = parameterReader.readParameter("a");
        final double b = parameterReader.readParameter("b");
        return factory.createExpression(a, b);
    }
}
