package edu.hw2;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;
import org.junit.jupiter.api.Assertions;

abstract class ExpressionTest extends Assertions {
    protected final ExpressionFactory factory;

    protected ExpressionTest(final int expressionNumber) {
        factory = new ExpressionFactory(expressionNumber);
    }

    @TestOnly
    protected abstract double evaluateExpression(
        final double a,
        final double b,
        final double x
    );

    @TestOnly
    protected void assertEquals(@NotNull final ExpressionTestArgs args) {
        assertEquals(
            factory.createExpression(args.a(), args.b()).evaluate(args.x()),
            evaluateExpression(args.a(), args.b(), args.x()),
            Double.MIN_VALUE
        );
    }
}
