package edu.hw2;

import java.util.HashMap;

public class ExpressionFactory {
    /**
     * The type of the expression to create.
     */
    private enum ExpressionType {
        /**
         * The first expression.
         */
        EXPRESSION1(1),
        /**
         * The second expression.
         */
        EXPRESSION2(2),
        /**
         * The third expression.
         */
        EXPRESSION3(3),
        /**
         * The fourth expression.
         */
        EXPRESSION4(4),
        /**
         * The fifth expression.
         */
        EXPRESSION5(5),
        /**
         * The sixth expression.
         */
        EXPRESSION6(6),
        /**
         * The seventh expression.
         */
        EXPRESSION7(7),
        /**
         * The eighth expression.
         */
        EXPRESSION8(8),

        /**
         * The ninth expression.
         */
        EXPRESSION9(9),
        /**
         * The tenth expression.
         */
        EXPRESSION10(10),
        /**
         * The eleventh expression.
         */
        EXPRESSION11(11),
        /**
         * The twelfth expression.
         */
        EXPRESSION12(12),
        /**
         * The thirteenth expression.
         */
        EXPRESSION13(13),
        /**
         * The fourteenth expression.
         */
        EXPRESSION14(14),
        /**
         * The fifteenth expression.
         */
        EXPRESSION15(15),
        /**
         * The sixteenth expression.
         */
        EXPRESSION16(16);

        /**
         * The number of the expression.
         */
        private final int expressionNumber;

        /**
         * The map of expression numbers to expression types.
         */
        private static final HashMap<Integer, ExpressionType> MAP
            = new HashMap<>();

        static {
            for (ExpressionType enumConstant : ExpressionType.values()) {
                MAP.put(enumConstant.expressionNumber, enumConstant);
            }
        }

        /**
         * Get the expression type from the number.
         *
         * @param value the number of the expression
         * @return the expression type
         */
        public static ExpressionType fromInt(final int value) {
            return MAP.get(value);
        }

        /**
         * Create a new expression type.
         *
         * @param i the number of the expression
         */
        ExpressionType(final int i) {
            expressionNumber = i;
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
     */
    public ExpressionFactory(final int expressionNumber) {
        expressionType = ExpressionType.fromInt(expressionNumber);
    }

    /**
     * Create the expression.
     *
     * @param a the value of the parameter a
     * @param b the value of the parameter b
     * @return the created expression
     * @throws IllegalArgumentException if the expression number is invalid
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
            default -> throw new IllegalArgumentException(
                "Invalid expression number: " + expressionType
            );
        };
    }
}
