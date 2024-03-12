package edu.hw1;

public final class HelloWorld {
    /**
     * This class should not be instantiated.
     */
    private HelloWorld() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This method prints "Hello, World!" to the console.
     */
    private static void printHelloWorld() {
        System.out.println("Hello, World!");
    }

    /**
     * This method is the entry point of the application.
     *
     * @param args The command-line arguments.
     */
    public static void main(final String[] args) {
        printHelloWorld();
    }
}
