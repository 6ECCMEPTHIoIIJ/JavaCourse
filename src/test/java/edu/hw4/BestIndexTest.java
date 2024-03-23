package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BestIndexTest  extends Assertions {
    private static final Integer[] EMPTY = new Integer[0];
    private static final Integer[] ORDERED =
        new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private static final Integer[] REVERSED =
        new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    private static final Integer[] MIXED =
        new Integer[] {3, 2, 1, 4, 5, 8, 7, 10, 6, 9};

    private static final Integer[] WITH_DUPLICATES =
        new Integer[] {1, 2, 3, 4, 5, 5, 3, 3, 4, 2, 5};

    private static final BestIndex<Integer> BI =
        new BestIndex<Integer>(Integer::compareTo);

    @Test
    void testEmpty() {
        assertEquals(-1, BI.all(EMPTY));
    }

    @Test
    void testOrdered() {
        assertEquals(9, BI.all(ORDERED));
    }

    @Test
    void testReversed() {
        assertEquals(0, BI.all(REVERSED));
    }

    @Test
    void testMixed() {
        assertEquals(7, BI.all(MIXED));
    }

    @Test
    void testWithDuplicates() {
        assertEquals(4, BI.all(WITH_DUPLICATES));
    }
}
