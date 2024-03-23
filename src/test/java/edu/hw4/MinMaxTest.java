package edu.hw4;

import java.util.Optional;
import org.junit.jupiter.api.Assertions;

class MinMaxTest extends Assertions {
    private static final Integer[] EMPTY = new Integer[0];
    private static final Integer[] ORDERED =
        new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private static final Integer[] REVERSED =
        new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    private static final Integer[] MIXED =
        new Integer[] {3, 2, 1, 4, 5, 8, 7, 10, 6, 9};

    private static final Integer[] WITH_DUPLICATES =
        new Integer[] {1, 2, 3, 4, 5, 5, 3, 3, 4, 2, 5};

    private static final MinMax<Integer> MIN = new MinMax<>();

    @org.junit.jupiter.api.Test
    void testEmpty() {
        assertEquals(Optional.empty(), MIN.all(EMPTY));
    }

    @org.junit.jupiter.api.Test
    void testOrdered() {
        assertEquals(
            Optional.of(new BestWorstPair<>(1, 10)),
            MIN.all(ORDERED)
        );
    }

    @org.junit.jupiter.api.Test
    void testReversed() {
        assertEquals(
            Optional.of(new BestWorstPair<>(1, 10)),
            MIN.all(REVERSED)
        );
    }

    @org.junit.jupiter.api.Test
    void testMixed() {
        assertEquals(
            Optional.of(new BestWorstPair<>(1, 10)),
            MIN.all(MIXED)
        );
    }

    @org.junit.jupiter.api.Test
    void testWithDuplicates() {
        assertEquals(
            Optional.of(new BestWorstPair<>(1, 5)),
            MIN.all(WITH_DUPLICATES)
        );
    }
}
