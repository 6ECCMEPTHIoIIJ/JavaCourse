package edu.hw2;

import java.util.Scanner;

public final class ArgumentReader {
    Scanner scanner = new Scanner(System.in);

    /**
     * Read the expression argument from the input source.
     *
     * @param argumentName the name of the argument
     * @return argument value
     */
    public double readArgument(String argumentName) {
        System.out.printf("Enter value for %s:\n", argumentName);
        return scanner.nextDouble();
    }
}
