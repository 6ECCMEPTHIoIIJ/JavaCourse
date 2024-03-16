package edu.hw2;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

final class Expression15Test extends ExpressionTest {
    private final static double EXPRESSION_EDGE = 2.0;

    public Expression15Test() {
        super(15);
    }

    @ParameterizedTest
    @DisplayName("Проверка значения выражения при x = 2")
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
        + "при которых под логарифмом стоит 0")
    @MethodSource("illegalExpressionArgsProviderFactory")
    public void divisionByZeroCheck(@NotNull final ExpressionTestArgs args) {
        assertNotNull(assertThrows(
            ArithmeticException.class,
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
        return x < EXPRESSION_EDGE
            ? Math.sin(x + a * a)
            : Math.log(x * x + 2.0 * x + b);
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

    private static @NotNull Stream<ExpressionTestArgs>
    illegalExpressionArgsProviderFactory() {
        return Stream.of(
            new ExpressionTestArgs(-36.0, -20.0, 3.0),
            new ExpressionTestArgs(-36.0, -8.0, 2.0)
        );
    }
}

