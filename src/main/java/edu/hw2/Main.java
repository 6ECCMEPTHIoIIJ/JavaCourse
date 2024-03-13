package edu.hw2;

import org.jetbrains.annotations.NotNull;

/**
 * The main class to run the expressions.
 */
public final class Main {
    /**
     * The private constructor to prevent instantiation of the class.
     */
    private Main() {
    }

    /**
     * The main method to run the expressions.
     *
     * @param args one integer: expression number
     * @throws InvalidNumberOfArgumentsException if the number of
     *                                           arguments is not equal to 1
     */
    public static void main(final String @NotNull [] args) {
        if (args.length != 1) {
            throw new InvalidNumberOfArgumentsException(1, args.length);
        }

        ParameterReader argumentReader = new ParameterReader();
        System.out.printf(
            "Evaluation result: %f\n",
            new TwoParametersExpressionReader(
                new ExpressionFactory(Integer.parseInt(args[0])))
                .readExpression()
                .evaluate(argumentReader.readParameter("x"))
        );
    }
}


