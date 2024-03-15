package edu.hw2;

import java.util.ArrayList;
import java.util.List;

public class ExpressionFactory {
    /**
     * The type of the expression to create.
     */
    private enum ExpressionType {
        /**
         * The first expression.
         */
        EXPRESSION1,
        /**
         * The second expression.
         */
        EXPRESSION2,
        /**
         * The third expression.
         */
        EXPRESSION3,
        /**
         * The fourth expression.
         */
        EXPRESSION4,
        /**
         * The fifth expression.
         */
        EXPRESSION5,
        /**
         * The sixth expression.
         */
        EXPRESSION6,
        /**
         * The seventh expression.
         */
        EXPRESSION7,
        /**
         * The eighth expression.
         */
        EXPRESSION8,

        /**
         * The ninth expression.
         */
        EXPRESSION9,
        /**
         * The tenth expression.
         */
        EXPRESSION10,
        /**
         * The eleventh expression.
         */
        EXPRESSION11,
        /**
         * The twelfth expression.
         */
        EXPRESSION12,
        /**
         * The thirteenth expression.
         */
        EXPRESSION13,
        /**
         * The fourteenth expression.
         */
        EXPRESSION14,
        /**
         * The fifteenth expression.
         */
        EXPRESSION15,
        /**
         * The sixteenth expression.
         */
        EXPRESSION16;

        /**
         * The map of expression numbers to expression types.
         */
        private static final List<ExpressionType> MAP
            = new ArrayList<>();

        static {
            for (ExpressionType enumConstant : ExpressionType.values()) {
                MAP.addLast(enumConstant);
            }
        }

        /**
         * Get the expression type from the number.
         *
         * @param value the number of the expression
         * @return the expression type
         */
        public static ExpressionType fromInt(final int value) {
            return MAP.get(value - 1);
        }
    }

    /**
     * The number of the expression to create.
     */
    private final ExpressionType expressionType;

    /**
     * Create a new expression factory.
     *
     * @param expressionNumber the number of the expression to create
     * @throws IllegalArgumentException if the expression number is invalid
     */
    public ExpressionFactory(final int expressionNumber) {
        expressionType = ExpressionType.fromInt(expressionNumber);
        if (expressionType == null) {
            throw new IllegalArgumentException("Invalid expression number");
        }
    }

    /**
     * Create the expression.
     *
     * @param a the value of the parameter a
     * @param b the value of the parameter b
     * @return the created expression
     */
    public Expression createExpression(final double a, final double b) {
        return switch (expressionType) {
            case EXPRESSION1 -> new Expression1(a, b);
            case EXPRESSION2 -> new Expression2(a, b);
            case EXPRESSION3 -> new Expression3(a, b);
            case EXPRESSION4 -> new Expression4(a, b);
            case EXPRESSION5 -> new Expression5(a, b);
            case EXPRESSION6 -> new Expression6(a, b);
            case EXPRESSION7 -> new Expression7(a, b);
            case EXPRESSION8 -> new Expression8(a, b);
            case EXPRESSION9 -> new Expression9(a, b);
            case EXPRESSION10 -> new Expression10(a, b);
            case EXPRESSION11 -> new Expression11(a, b);
            case EXPRESSION12 -> new Expression12(a, b);
            case EXPRESSION13 -> new Expression13(a, b);
            case EXPRESSION14 -> new Expression14(a, b);
            case EXPRESSION15 -> new Expression15(a, b);
            case EXPRESSION16 -> new Expression16(a, b);
        };
    }
}
