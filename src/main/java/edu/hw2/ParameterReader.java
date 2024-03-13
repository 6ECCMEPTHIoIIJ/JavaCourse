package edu.hw2;

import java.util.Scanner;
import org.jetbrains.annotations.NotNull;

/**
 * A class to read the expression parameter from the input source.
 */
public final class ParameterReader {
    /**
     * The scanner to read the input from.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Read the expression argument from the input source.
     *
     * @param parameterName the name of the parameter
     * @return argument value
     */
    public double readParameter(final @NotNull String parameterName) {
        System.out.printf("Enter value for %s:\n", parameterName);
        return scanner.nextDouble();
    }
}
