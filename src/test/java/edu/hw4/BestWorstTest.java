package edu.hw4;

import java.util.Comparator;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;

class BestWorstTest extends Assertions {
    private static final Integer[] EMPTY = new Integer[0];
    private static final Integer[] ORDERED =
        new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private static final Integer[] REVERSED =
        new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    private static final Integer[] MIXED =
        new Integer[] {3, 2, 1, 4, 5, 8, 7, 10, 6, 9};

    private static final Integer[] WITH_DUPLICATES =
        new Integer[] {1, 2, 3, 4, 5, 5, 3, 3, 4, 2, 5};

    private static final BestWorst<Integer> BW =
        new BestWorst<Integer>(Comparator.naturalOrder());

    @org.junit.jupiter.api.Test
    void testEmpty() {
        assertEquals(Optional.empty(), BW.all(EMPTY));
    }

    @org.junit.jupiter.api.Test
    void testOrdered() {
        assertEquals(
            Optional.of(new BestWorstPair<>(10, 1)),
            BW.all(ORDERED)
        );
    }

    @org.junit.jupiter.api.Test
    void testReversed() {
        assertEquals(
            Optional.of(new BestWorstPair<>(10, 1)),
            BW.all(REVERSED)
        );
    }

    @org.junit.jupiter.api.Test
    void testMixed() {
        assertEquals(
            Optional.of(new BestWorstPair<>(10, 1)),
            BW.all(MIXED)
        );
    }

    @org.junit.jupiter.api.Test
    void testWithDuplicates() {
        assertEquals(
            Optional.of(new BestWorstPair<>(5, 1)),
            BW.all(WITH_DUPLICATES)
        );
    }
}
