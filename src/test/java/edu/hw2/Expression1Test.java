package edu.hw2;

import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

final class Expression1Test extends ExpressionTest {
    private final static double EXPRESSION_EDGE = 3.0;

    public Expression1Test() {
        super(1);
    }

    @ParameterizedTest
    @DisplayName("Проверка значения выражения при x = 3")
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
        + "при которых проиходит деление на 0")
    @MethodSource("illegalExpressionArgsProviderFactory")
    public void divisionByZeroCheck(@NotNull final ExpressionTestArgs args) {
        assertNotNull(assertThrows(
            DivisionByZeroException.class,
            () -> factory.createExpression(args.a(), args.b()).evaluate(args.x())
        ));
    }

    @Test
    @DisplayName("Проверка выражения при значениях x, "
        + "при которых под логарифмом стоит 0")
    public void zeroUnderLogarithmCheck() {
        assertNotNull(assertThrows(
            IllegalArgumentException.class,
            () -> factory.createExpression(3.0, 6.0).evaluate(0.0)
        ));
    }

    @Override
    @TestOnly
    protected double evaluateExpression(
        final double a,
        final double b,
        final double x
    ) {
        final double xSqr = x * x;
        return x <= EXPRESSION_EDGE
            ? b + 2.0 * Math.log(Math.abs(x))
            : xSqr / (xSqr + a);
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
            new ExpressionTestArgs(-36.0, -2.0, 6.0),
            new ExpressionTestArgs(-49.0, 0.0, 7.0)
        );
    }
}

final class Expression4Test extends ExpressionTest {
    private final static double EXPRESSION_EDGE = 2.0;
    public Expression4Test() {
        super(4);
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
        + "при которых проиходит деление на 0")
    @MethodSource("illegalExpressionArgsProviderFactory")
    public void divisionByZeroCheck(@NotNull final ExpressionTestArgs args) {
        assertNotNull(assertThrows(
            DivisionByZeroException.class,
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
        return x <= EXPRESSION_EDGE
            ? (a + x * x) / (b + Math.log(Math.abs(x) + 1))
            : Math.exp(x) + x * x;
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
            new ExpressionTestArgs(4.0, -1.0, Math.E - 1),
            new ExpressionTestArgs(2.0, 0.0, 0.0)
        );
    }
}

