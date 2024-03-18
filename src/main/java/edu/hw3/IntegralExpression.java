package edu.hw3;

import java.util.function.Supplier;

public class IntegralExpression implements Expression {
    private final Supplier<IntegralElement> factory;
    private final IntegralExpressionArgBoundsChecker checker;

    public IntegralExpression(
        Supplier<IntegralElement> elementFactory,
        IntegralExpressionArgBoundsChecker boundsChecker
    ) {
        factory = elementFactory;
        checker = boundsChecker;
    }

    public IntegralExpression(
        Supplier<IntegralElement> elementFactory
    ) {
        this(elementFactory, null);
    }

    @Override
    public double evaluate(double x) {
        if (checker != null && !checker.checkBounds(x)) {
            throw new IllegalArgumentException(
                "Argument x is out of bounds"
            );
        }

        return MathUtils.integrate(factory.get(), x);
    }
}
