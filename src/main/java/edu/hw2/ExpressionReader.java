package edu.hw2;

import java.util.Scanner;

public abstract class ExpressionReader {

    /**
     * The reader of expression parameters.
     */
    private final ParameterReader parameterReader = new ParameterReader();

    /**
     * Get the parameter reader.
     *
     * @return the parameter reader
     */
    protected ParameterReader getParameterReader() {
        return parameterReader;
    }

    /**
     * Read the expression parameters from the console.
     *
     * @return the expression
     */
    public abstract Expression readExpression();
}
