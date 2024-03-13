package edu.hw2;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * The main class to run the expressions.
 */
public final class ExpressionsRunner {
    /**
     * Choose the expression reader based on the expression number.
     *
     * @param expressionNumber the number of the expression to choose the reader for
     * @return the chosen expression reader
     * @throws IllegalArgumentException if the expression number is invalid
     */
    @Contract("_ -> new") private static @NotNull ExpressionReader chooseExpressionReader(int expressionNumber) {
        switch (expressionNumber) {
            case 1:
                return new Expression1Reader();
            default:
                throw new IllegalArgumentException("Invalid expression number");
        }
    }

    /**
     * The main method to run the expressions.
     *
     * @param args one integer: expression number
     * @throws IllegalArgumentException if the number of arguments is not equal to 1
     */
    public static void main(String @NotNull [] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("No arguments provided (expected 1 argument: expression number)");
        } else if (args.length > 1) {
            throw new IllegalArgumentException("Too many arguments provided (expected 1 argument: expression number)");
        }

        System.out.printf(
            "Evaluation result: %f\n",
            chooseExpressionReader(Integer.parseInt(args[0])).readExpression()
                .evaluate(new double[] {
                    new ArgumentReader().readArgument("x")
                })
        );
    }
}
