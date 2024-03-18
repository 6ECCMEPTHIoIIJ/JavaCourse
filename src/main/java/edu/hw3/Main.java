package edu.hw3;

public class Main {
    public static void main(final String[] args) {
        Expression expression = new Expression1();

        System.out.println(expression.evaluate(1.0));
        expression = new Expression2();
        System.out.println(expression.evaluate(0));
    }
}
