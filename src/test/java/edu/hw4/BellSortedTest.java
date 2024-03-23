package edu.hw4;

import java.util.Comparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BellSortedTest extends Assertions {
    private static final Integer[] EMPTY = new Integer[0];
    private static final Integer[] ORDERED =
        new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private static final Integer[] COMMON_SORTED =
        new Integer[] {1, 3, 5, 7, 9, 10, 8, 6, 4, 2};

    private static final Integer[] REVERSED =
        new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    private static final Integer[] MIXED =
        new Integer[] {3, 2, 1, 4, 5, 8, 7, 6, 9, 10};

    private static final Integer[] WITH_DUPLICATES =
        new Integer[] {1, 2, 3, 4, 5, 5, 3, 3, 4, 2, 5};

    private static final Integer[] WITH_DUPLICATES_SORTED =
        new Integer[] {1, 2, 3, 4, 5, 5, 5, 4, 3, 3, 2};

    private static final BellSorted<Integer> BS =
        new BellSorted<Integer>(Comparator.naturalOrder());

    @Test
    void testEmpty() {
        assertArrayEquals(EMPTY, BS.all(EMPTY));
    }

    @Test
    void testOrdered() {
        assertArrayEquals(COMMON_SORTED, BS.all(ORDERED));
    }

    @Test
    void testReversed() {
        assertArrayEquals(COMMON_SORTED, BS.all(REVERSED));
    }

    @Test
    void testMixed() {
        assertArrayEquals(COMMON_SORTED, BS.all(MIXED));
    }

    @Test
    void testWithDuplicates() {
        assertArrayEquals(WITH_DUPLICATES_SORTED, BS.all(WITH_DUPLICATES));
    }

}
