package edu.hw2;

public class TwoParametersExpressionReader extends ExpressionReader {

    private final ExpressionFactory factory;

    public TwoParametersExpressionReader(ExpressionFactory expressionFactory) {
        factory = expressionFactory;
    }

    @Override
    public Expression readExpression() {
        return factory.createExpression(
            getParameterReader().readParameter("a"),
            getParameterReader().readParameter("b")
        );
    }
}
