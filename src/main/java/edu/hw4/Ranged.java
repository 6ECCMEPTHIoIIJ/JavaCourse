package edu.hw4;

/**
 * A range operation on an array.
 *
 * @param <T> the element type
 * @param <R> the result type
 */
public interface Ranged<T, R> {
    /**
     * Applies the operation to the elements in the range [from, to).
     *
     * @param a    the array
     * @param from the start index (inclusive)
     * @param to   the end index (exclusive)
     * @return the result of the operation
     */
    R inRange(T[] a, int from, int to);

    /**
     * Applies the operation to the elements in the range [from, a.length).
     *
     * @param a    the array
     * @param from the start index (inclusive)
     * @return the result of the operation
     */
    default R after(T[] a, int from) {
        return inRange(a, from, a.length);
    }

    /**
     * Applies the operation to the elements in the range [0, to).
     *
     * @param a  the array
     * @param to the end index (exclusive)
     * @return the result of the operation
     */
    default R before(T[] a, int to) {
        return inRange(a, 0, to);
    }

    /**
     * Applies the operation to all elements in the array.
     *
     * @param a the array
     * @return the result of the operation
     */
    default R all(T[] a) {
        return inRange(a, 0, a.length);
    }
}
