package edu.hw4;

import java.util.Comparator;
import org.junit.jupiter.api.Assertions;

class SortedIndexedTest extends Assertions {
    private static final Integer[] EMPTY = new Integer[0];
    private static final Integer[] ORDERED =
        new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private static final Integer[] REVERSED =
        new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    private static final Integer[] MIXED =
        new Integer[] {3, 2, 1, 4, 5, 8, 7, 10, 6, 9};

    private static final Integer[] WITH_DUPLICATES =
        new Integer[] {1, 2, 3, 4, 5, 5, 3, 3, 4, 2, 5};

    private static final SortedIndexed<Integer> S =
        new SortedIndexed<Integer>(Comparator.naturalOrder());

    @org.junit.jupiter.api.Test
    void testEmpty() {
        assertArrayEquals(new int[0], S.all(EMPTY));
    }

    @org.junit.jupiter.api.Test
    void testOrdered() {
        assertArrayEquals(
            new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
            S.all(ORDERED)
        );
    }

    @org.junit.jupiter.api.Test
    void testReversed() {
        assertArrayEquals(
            new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0},
            S.all(REVERSED)
        );
    }

    @org.junit.jupiter.api.Test
    void testMixed() {
        assertArrayEquals(
            new int[] {2, 1, 0, 3, 4, 8, 6, 5, 9, 7},
            S.all(MIXED)
        );
    }

    @org.junit.jupiter.api.Test
    void testWithDuplicates() {
        assertArrayEquals(
            new int[] {0, 1, 9, 2, 6, 7, 3, 8, 4, 5, 10},
            S.all(WITH_DUPLICATES)
        );
    }
}
