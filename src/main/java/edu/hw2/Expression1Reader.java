package edu.hw2;

import java.util.Scanner;

public class Expression1Reader implements ExpressionReader {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Expression readExpression() {
        System.out.println("Enter value for a:");
        double a = scanner.nextDouble();

        System.out.println("Enter value for b:");
        double b = scanner.nextDouble();

        return new Expression1(a, b);
    }
}
