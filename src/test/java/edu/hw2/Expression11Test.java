package edu.hw2;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

final class Expression11Test extends ExpressionTest {
    private final static double EXPRESSION_EDGE = 4.0;

    public Expression11Test() {
        super(11);
    }

    @ParameterizedTest
    @DisplayName("Проверка значения выражения при x = 4")
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

    @ParameterizedTest
    @DisplayName("Проверка выражения при значениях x, "
        + "при подкоренное выражение отрицательное")
    @MethodSource("illegalExpressionArgsProviderFactory")
    public void divisionByZeroCheck(@NotNull final ExpressionTestArgs args) {
        assertNotNull(assertThrows(
            IllegalArgumentException.class,
            () -> factory.createExpression(args.a(), args.b()).evaluate(args.x())
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
            ? Math.sqrt(a + Math.abs(Math.sin(x)))
            : Math.tan(b * x);
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
            new ExpressionTestArgs(1.0, 15.0, 6.0)
        );
    }

    private static @NotNull Stream<ExpressionTestArgs>
    illegalExpressionArgsProviderFactory() {
        return Stream.of(
            new ExpressionTestArgs(-1.0, -2.0, 4.1),
            new ExpressionTestArgs(-2.0, 0.0, 3 * Math.PI)
        );
    }
}