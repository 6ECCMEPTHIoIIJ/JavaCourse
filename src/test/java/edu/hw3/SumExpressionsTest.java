package edu.hw3;

import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class SumExpressionsTest extends Assertions {
    private static void runExpr(
        final @NotNull SumExpr sum,
        final double lower, final double upper,
        final int nSteps, final double precision
    ) {
        System.out.printf(
            "=== %s ===%n",
            sum.getClass().getSimpleName()
        );
        double step = (upper - lower) / nSteps;
        for (double i = lower; i <= upper; i += step) {
            System.out.printf("\t|_ Sum(f(%f)) \t= %f%n",
                i, sum.evaluate(i, precision)
            );
        }
    }

    private static void runExpr(
        final SumExpr sum,
        final double lower, final double upper,
        final int nSteps
    ) {
        runExpr(sum, lower, upper, nSteps, Double.MIN_VALUE);
    }

    private static void runExpr(
        final SumExpr sum,
        final double lower, final double upper
    ) {
        runExpr(sum, lower, upper, 10);
    }

    @ParameterizedTest
    @MethodSource("exprRunnersProvider")
    public void run(@NotNull ExprProvider exprProvider) {
        assertDoesNotThrow(exprProvider::run);
    }

    public interface ExprProvider {
        void run();
    }

    private static @NotNull Stream<ExprProvider>
    exprRunnersProvider() {
        return Stream.of(
            () -> runExpr(new SumExpr1(), -10.0, 10.0),
            () -> runExpr(new SumExpr2(), -0.99, 0.99),
            () -> runExpr(new SumExpr3(), -0.99, 0.99),
            () -> runExpr(new SumExpr4(), -20.0, 20.0, 40),
            () -> runExpr(new SumExpr5(), -20.0, 20.0, 40),
            () -> runExpr(new SumExpr6(), -10.0, 10.0, 20),
            () -> runExpr(new SumExpr7(), -10.0, 10.0, 15),
            () -> runExpr(new SumExpr8(), -10.0, 10.0),
            () -> runExpr(new SumExpr9(), -0.9, 0.9, 5, 1e-3),
            () -> runExpr(new SumExpr10(), -0.9, 0.9, 5, 1e-3),
            () -> runExpr(new SumExpr11(), -0.9, 0.9, 10, 1e-3),
            () -> runExpr(new SumExpr12(), -0.9 / 4.0, 1.0 / 2.0, 10, 1e-3),
            () -> runExpr(new SumExpr13(), -1.0, 1.0, 10, 1e-3),
            () -> runExpr(new SumExpr14(), -1.0, 1.0, 10, 1e-3),
            () -> runExpr(new SumExpr15(), -1.0, 1.0, 10, 1e-3),
            () -> runExpr(new SumExpr16(), -1.0, 1.0, 10, 1e-3)
        );
    }
}
