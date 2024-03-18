package edu.hw3;

public abstract class IntegralExpressionArgBoundsChecker {
    protected final Bounds bounds;

    protected IntegralExpressionArgBoundsChecker(Bounds argBounds) {
        this.bounds = argBounds;
    }

    boolean checkBounds(double x) {
        return bounds.lower() < x && x < bounds.upper();
    }
}
