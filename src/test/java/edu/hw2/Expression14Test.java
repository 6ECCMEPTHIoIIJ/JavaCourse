package edu.hw2;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

final class Expression14Test extends ExpressionTest {
    private final static double EXPRESSION_EDGE = -1.0;

    public Expression14Test() {
        super(14);
    }

    @ParameterizedTest
    @DisplayName("Проверка значения выражения при x = -1")
    @MethodSource("edgeExpressionArgsProviderFactory")
    public void checkEdge(@NotNull final ExpressionTestArgs args) {
        assertEquals(args);
    }

    @ParameterizedTest
    @DisplayName("Проверка значения выражения при разных значениях х")
    @MethodSource("commonExpressionArgsProviderFactory")
    public void commonCheck(@NotNull final ExpressionTestArgs args) {
        assertEquals(args);
    }

    @Test
    @DisplayName("Проверка выражения при значениях x, "
        + "при которых под логарифмом стоит 0")
    public void zeroUnderLogarithmCheck() {
        assertNotNull(assertThrows(
            IllegalArgumentException.class,
            () -> factory.createExpression(3.0, 6.0).evaluate(-3.0)
        ));
    }

    @Override
    @TestOnly
    protected double evaluateExpression(
        final double a,
        final double b,
        final double x
    ) {
        return x > EXPRESSION_EDGE
            ? 0.2 * x * x * x + a
            : b * x * x + Math.log(Math.abs(x + 3.0));
    }

    private static @NotNull Stream<ExpressionTestArgs>
    edgeExpressionArgsProviderFactory() {
        return Stream.of(
            new ExpressionTestArgs(0.0, 1.0, EXPRESSION_EDGE),
            new ExpressionTestArgs(5.0, 1.0, EXPRESSION_EDGE),
            new ExpressionTestArgs(-10.0, 1.0, EXPRESSION_EDGE)
        );
    }

    private static @NotNull Stream<ExpressionTestArgs>
    commonExpressionArgsProviderFactory() {
        return Stream.of(
            new ExpressionTestArgs(0.0, 1.0, 1.0),
            new ExpressionTestArgs(0.0, -12.0, -100.0),
            new ExpressionTestArgs(63.0, 17.0, 5.0),
            new ExpressionTestArgs(-63.0, 15.0, 6.0),
            new ExpressionTestArgs(-36.0, 15.0, -6.0)
        );
    }
}
