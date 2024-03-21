package edu.hw4;

import java.util.Arrays;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * A slice of an array.
 * The slice is defined by the index of the first element
 * and the index of the element after the last element.
 * The slice refers to the same array as the original array.
 *
 * @param <T> the type of elements in the slice
 */
public final class ArraySlice<T> {
    /**
     * The array of elements.
     */
    private T[] data;
    /**
     * The index of the first element in the slice.
     */
    private int begin;
    /**
     * The index of the element after the last element in the slice.
     */
    private int end;

    /**
     * Constructs a new slice of the given array.
     * The slice will contain the elements from the given
     * begin index to the given end index.
     *
     * @param newData  the array of elements
     * @param newBegin the index of the first element in the slice
     * @param newEnd   the index of the element
     *                 after the last element in the slice
     */
    public ArraySlice(
        final T @NotNull [] newData,
        final int newBegin,
        final int newEnd
    ) {
        if (newBegin < 0 || newBegin > newEnd || newEnd > newData.length) {
            throw new IllegalArgumentException(
                "Invalid slice bounds: [" + newBegin + ", " + newEnd + ")");
        }

        this.data = newData;
        this.begin = newBegin;
        this.end = newEnd;
    }

    /**
     * Constructs a new slice of the given array.
     * The slice will contain the elements from the beginning
     * of the array to the given index.
     *
     * @param newData the array of elements
     * @param newEnd  the index of the element after the last
     *                element in the slice
     */
    public ArraySlice(
        final T @NotNull [] newData,
        final int newEnd
    ) {
        this(newData, 0, newEnd);
    }

    /**
     * Constructs a new slice of the given array.
     * The slice will contain all the elements of the array.
     *
     * @param newData the array of elements
     */
    public ArraySlice(final T @NotNull [] newData) {
        this(newData, newData.length);
    }

    /**
     * Constructs a new slice of the given array.
     * The slice will contain the elements from the given begin
     * index to the given end index.
     *
     * @param newData  the array of elements
     * @param newBegin the index of the first element in the slice
     * @param newEnd   the index of the element after the last
     *                 element in the slice
     * @param <T>      the type of elements in the slice
     * @return the new slice
     */
    @Contract(value = "_, _, _ -> new", pure = true) public static <T>
    @NotNull ArraySlice<T> ofRange(
        final T @NotNull [] newData,
        final int newBegin,
        final int newEnd
    ) {
        return new ArraySlice<>(newData, newBegin, newEnd);
    }

    /**
     * Constructs a new slice of the given array.
     * The slice will contain the elements from the beginning of
     * the array to the given index.
     *
     * @param newData the array of elements
     * @param newEnd  the index of the element after the last
     *                element in the slice
     * @param <T>     the type of elements in the slice
     * @return the new slice
     */
    @Contract(value = "_, _ -> new", pure = true) public static <T>
    @NotNull ArraySlice<T> ofTo(
        final T @NotNull [] newData,
        final int newEnd
    ) {
        return new ArraySlice<>(newData, newEnd);
    }

    /**
     * Constructs a new slice of the given array.
     * The slice will contain the elements from the given index
     * to the end of the array.
     *
     * @param newData  the array of elements
     * @param newBegin the index of the first element in the slice
     * @param <T>      the type of elements in the slice
     * @return the new slice
     */
    @Contract(value = "_, _ -> new", pure = true) public static <T>
    @NotNull ArraySlice<T> ofFrom(
        final T @NotNull [] newData,
        final int newBegin
    ) {
        return new ArraySlice<>(newData, newBegin, newData.length);
    }

    /**
     * Constructs a new slice of the given array.
     * The slice will contain all the elements of the array.
     *
     * @param newData the array of elements
     * @param <T>     the type of elements in the slice
     * @return the new slice
     */
    @Contract(value = "_ -> new", pure = true) public static <T>
    @NotNull ArraySlice<T> of(final T @NotNull [] newData) {
        return new ArraySlice<>(newData);
    }

    /**
     * Constructs a new slice of the given slice.
     * The slice will contain the elements from the given begin
     * index to the given end index.
     *
     * @param other    the slice to copy
     * @param newBegin the index of the first element in the slice
     * @param newEnd   the index of the element after the last
     *                 element in the slice
     * @param <T>      the type of elements in the slice
     * @return the new slice
     */
    @Contract(value = "_, _, _ -> new", pure = true) public static <T>
    @NotNull ArraySlice<T> ofRange(
        final @NotNull ArraySlice<T> other,
        final int newBegin,
        final int newEnd
    ) {
        return new ArraySlice<>(other.data, newBegin, newEnd);
    }

    /**
     * Constructs a new slice of the given slice.
     * The slice will contain the elements from the given index
     * to the end of the slice.
     * Data will refer to the same array as the given slice.
     *
     * @param other    the slice to refer
     * @param newBegin the index of the first element in the slice
     * @param <T>      the type of elements in the slice
     * @return the new slice
     */
    @Contract(value = "_, _ -> new", pure = true) public static <T>
    @NotNull ArraySlice<T> ofFrom(
        final @NotNull ArraySlice<T> other,
        final int newBegin
    ) {
        return new ArraySlice<>(other.data, newBegin, other.end);
    }

    /**
     * Constructs a new slice of the given slice.
     * The slice will contain the elements from the beginning
     * of the slice to the given index.
     * Data will refer to the same array as the given slice.
     *
     * @param other  the slice to refer
     * @param newEnd the index of the element after the last
     *               element in the slice
     * @param <T>    the type of elements in the slice
     * @return the new slice
     */
    public static <T> ArraySlice<T> ofTo(
        final @NotNull ArraySlice<T> other,
        final int newEnd
    ) {
        return new ArraySlice<>(other.data, other.begin, newEnd);
    }

    /**
     * Returns the index of the first element in the slice.
     *
     * @return the index of the first element in the slice
     */
    public int getBegin() {
        return begin;
    }

    /**
     * Returns the index of the element after the last element in the slice.
     *
     * @return the index of the element after the last element in the slice
     */
    public int getEnd() {
        return end;
    }

    /**
     * Returns the number of elements in the slice.
     *
     * @return the number of elements in the slice
     */
    public int getSize() {
        return end - begin;
    }

    /**
     * Returns the array of elements.
     *
     * @return the array of elements
     */
    public T[] getData() {
        return data;
    }

    /**
     * Returns the element at the given index.
     * If the index is less than 0 or greater than the
     * current size of the slice,
     * an {@link IndexOutOfBoundsException} exception will be thrown.
     *
     * @param index the index of the element to return
     * @return the element at the given index
     */
    public T get(final int index) {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException(
                "Index out of bounds: " + index);
        }

        return data[begin + index];
    }

    /**
     * Sets the element at the given index to the given value.
     * If the index is less than 0 or greater than
     * the current size of the slice,
     * an {@link IndexOutOfBoundsException} exception will be thrown.
     *
     * @param index the index of the element to set
     * @param value the new value of the element
     */
    public void set(final int index, final T value) {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException(
                "Index out of bounds: " + index);
        }

        data[begin + index] = value;
    }

    /**
     * Sets the beginning index of the slice.
     * If the new beginning index is less than 0 or
     * greater than the current end index,
     * an {@link IllegalArgumentException} exception will be thrown.
     *
     * @param newBegin the new beginning index of the slice
     */
    public void setBegin(final int newBegin) {
        if (newBegin < 0 || newBegin > end) {
            throw new IllegalArgumentException(
                "New begin must be non-negative: " + newBegin);
        }

        begin = newBegin;
    }

    /**
     * Sets the end index of the slice.
     * If the new end index is less than the current begin index,
     * an {@link IllegalArgumentException} exception will be thrown.
     * If the new end index is greater than the current length of the array,
     * the array will be extended with null elements.
     *
     * @param newEnd the new end index of the slice
     */
    public void setEnd(final int newEnd) {
        if (newEnd < begin) {
            throw new IllegalArgumentException(
                "New end must be non-negative: " + newEnd);
        }

        if (newEnd > data.length) {
            data = Arrays.copyOf(data, newEnd);
        }

        end = newEnd;
    }

    /**
     * Resizes the slice so that it contains the given number of elements.
     * If the new size is less than the current size,
     * the slice will be truncated.
     * If the new size is greater than the current size,
     * the slice will be extended with null elements.
     *
     * @param newSize the new size of the slice
     */
    public void resize(final int newSize) {
        if (newSize < 0) {
            throw new IllegalArgumentException(
                "New size must be non-negative: " + newSize);
        }

        setEnd(begin + newSize);
    }

    /**
     * Trims the slice so that it contains only the elements
     * from the beginning index to the end index.
     */
    public void trim() {
        if (begin == 0 && end == data.length) {
            return;
        }

        data = Arrays.copyOfRange(data, begin, end);
        begin = 0;
        end = data.length;
    }

    /**
     * Returns a string representation of the slice.
     * The string representation consists of a list of the
     * slice's elements, enclosed in square brackets ("[]").
     *
     * @return a string representation of the slice
     */
    public @NotNull String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = begin; i < end; i++) {
            sb.append(data[i]);
            if (i < end - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
