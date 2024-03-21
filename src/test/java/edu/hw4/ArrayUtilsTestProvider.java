package edu.hw4;

import java.util.stream.Stream;

public class ArrayUtilsTestProvider {

    public record FindIndexArg<T>(ArraySlice<T> array, int expected) {
        public static <T> FindIndexArg<T> of(ArraySlice<T> array, int expected) {
            return new FindIndexArg<>(array, expected);
        }
    }

    public record FindMinMaxIndexArg<T>(ArraySlice<T> array, int expectedMin, int expectedMax) {
        public static <T> FindMinMaxIndexArg<T> of(ArraySlice<T> array, int expectedMin, int expectedMax) {
            return new FindMinMaxIndexArg<>(array, expectedMin, expectedMax);
        }
    }

    public record EraseArg<T>(ArraySlice<T> got, T value, ArraySlice<T> expected) {
        public static <T> EraseArg<T> of(ArraySlice<T> got, T value, ArraySlice<T> expected) {
            return new EraseArg<>(got, value, expected);
        }
    }

    public record SliceArg<T>(ArraySlice<T> got, ArraySlice<T> expected) {
        public static <T> SliceArg<T> of(ArraySlice<T> got, ArraySlice<T> expected) {
            return new SliceArg<>(got, expected);
        }
    }

    public static Stream<FindIndexArg<Double>> provideFindMinIndex() {
        return Stream.of(
            FindIndexArg.of(ArraySlice.of(new Double[0]), -1),
            FindIndexArg.of(
                ArraySlice.ofRange(
                    new Double[] {4.0, 2.0, 6.0, 5.0, 7.0, 4.0, 3.0, 2.0, 1.0},
                    4, 4
                ),
                -1
            ),

            FindIndexArg.of(
                ArraySlice.of(
                    new Double[] {4.0, 2.0, 6.0, 5.0, 7.0, 4.0, 3.0, 2.0, 1.0}
                ),
                8
            ),
            FindIndexArg.of(
                ArraySlice.of(
                    new Double[] {-6.0, 12.0, -9.0, 0.0}
                ),
                2
            ),

            FindIndexArg.of(
                ArraySlice.of(
                    new Double[] {3.0, 3.0, 3.0, 3.0}
                ),
                0
            ),
            FindIndexArg.of(
                ArraySlice.of(
                    new Double[] {-12.0}
                ),
                0
            )
        );
    }

    public static Stream<FindIndexArg<Double>> provideFindMaxIndex() {
        return Stream.of(
            FindIndexArg.of(ArraySlice.of(new Double[0]), -1),
            FindIndexArg.of(
                ArraySlice.ofRange(
                    new Double[] {4.0, 2.0, 6.0, 5.0, 7.0, 4.0, 3.0, 2.0, 1.0},
                    4, 4
                ),
                -1
            ),

            FindIndexArg.of(
                ArraySlice.of(
                    new Double[] {4.0, 2.0, 6.0, 5.0, 7.0, 4.0, 3.0, 2.0, 1.0}
                ),
                4
            ),
            FindIndexArg.of(
                ArraySlice.of(
                    new Double[] {-6.0, 12.0, -9.0, 0.0}
                ),
                1
            ),

            FindIndexArg.of(
                ArraySlice.of(
                    new Double[] {3.0, 3.0, 3.0, 3.0}
                ),
                0
            ),
            FindIndexArg.of(
                ArraySlice.of(
                    new Double[] {-12.0}
                ),
                0
            )
        );
    }

    public static Stream<FindMinMaxIndexArg<Double>> provideFindMinMaxIndex() {
        return Stream.of(
            FindMinMaxIndexArg.of(ArraySlice.of(new Double[0]), -1, -1),
            FindMinMaxIndexArg.of(
                ArraySlice.ofRange(
                    new Double[] {4.0, 2.0, 6.0, 5.0, 7.0, 4.0, 3.0, 2.0, 1.0},
                    4, 4
                ),
                -1, -1
            ),

            FindMinMaxIndexArg.of(
                ArraySlice.of(
                    new Double[] {4.0, 2.0, 6.0, 5.0, 7.0, 4.0, 3.0, 2.0, 1.0}
                ),
                8, 4
            ),
            FindMinMaxIndexArg.of(
                ArraySlice.of(
                    new Double[] {-6.0, 12.0, -9.0, 0.0}
                ),
                2, 1
            ),

            FindMinMaxIndexArg.of(
                ArraySlice.of(
                    new Double[] {3.0, 3.0, 3.0, 3.0}
                ),
                0, 0
            ),
            FindMinMaxIndexArg.of(
                ArraySlice.of(
                    new Double[] {-12.0}
                ),
                0, 0
            )
        );
    }

    public static Stream<EraseArg<Double>> provideErase() {
        return Stream.of(
            EraseArg.of(
                ArraySlice.of(new Double[0]),
                0.0,
                ArraySlice.of(new Double[0])
            ),
            EraseArg.of(
                ArraySlice.of(new Double[] {1.0, 3.0, -19.0}),
                0.0,
                ArraySlice.of(new Double[] {1.0, 3.0, -19.0})
            ),

            EraseArg.of(
                ArraySlice.of(new Double[] {1.0, 3.0, -19.0}),
                1.0,
                ArraySlice.of(new Double[] {3.0, -19.0})
            ),
            EraseArg.of(
                ArraySlice.of(new Double[] {1.0, 3.0, -19.0}),
                -19.0,
                ArraySlice.of(new Double[] {1.0, 3.0})
            ),

            EraseArg.of(
                ArraySlice.of(new Double[] {1.0, 3.0, 3.0, -19.0, 3.0}),
                3.0,
                ArraySlice.of(new Double[] {1.0, -19.0})
            ),
            EraseArg.of(
                ArraySlice.of(new Double[] {-19.0, -19.0, -19.0}),
                -19.0,
                ArraySlice.of(new Double[0])
            ),

            EraseArg.of(
                ArraySlice.ofRange(new Double[] {1.0, 3.0, 3.0, -19.0, 3.0}, 2, 3),
                3.0,
                ArraySlice.of(new Double[0])
            ),
            EraseArg.of(
                ArraySlice.ofRange(new Double[] {1.0, 3.0, 3.0, -19.0, 3.0}, 3, 3),
                -3.0,
                ArraySlice.of(new Double[0])
            )
        );
    }
}
