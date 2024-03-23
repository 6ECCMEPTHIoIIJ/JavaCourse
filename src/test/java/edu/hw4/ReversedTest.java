package edu.hw4;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

class ReversedTest extends Assertions {
    private static final Integer[] EMPTY = new Integer[0];
    private static final Integer[] ORDERED =
        new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private static final Integer[] REVERSED =
        new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    private static final Integer[] MIXED =
        new Integer[] {3, 2, 1, 4, 5, 8, 7, 10, 6, 9};

    private static final Integer[] WITH_DUPLICATES =
        new Integer[] {1, 2, 3, 4, 5, 5, 3, 3, 4, 2, 5};

    private static final Reversed<Integer> R = new Reversed<>();

    @org.junit.jupiter.api.Test
    void testEmpty() {
        assertArrayEquals(EMPTY, R.all(EMPTY));
    }

    @org.junit.jupiter.api.Test
    void testOrdered() {
        assertArrayEquals(
            new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
            R.all(ORDERED)
        );
    }

    @org.junit.jupiter.api.Test
    void testReversed() {
        assertArrayEquals(
            new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            R.all(REVERSED)
        );
    }

    @org.junit.jupiter.api.Test
    void testMixed() {
        assertArrayEquals(
            new Integer[] {9, 6, 10, 7, 8, 5, 4, 1, 2, 3},
            R.all(MIXED)
        );
    }

    @org.junit.jupiter.api.Test
    void testWithDuplicates() {
        assertArrayEquals(
            new Integer[] {5, 2, 4, 3, 3, 5, 5, 4, 3, 2, 1},
            R.all(WITH_DUPLICATES)
        );
    }

}
