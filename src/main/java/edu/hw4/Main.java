package edu.hw4;

public class Main {
    public static void main(String[] args) {
        ArraySlice<Double> array = ArraySlice.of(new Double[] {4.0, 2.0, 6.0, 5.0, 7.0, 4.0, 3.0, 2.0, 1.0});
        System.out.println(array);

        ArrayUtils.eraseUnordered(array);
        System.out.println(ArrayUtils.toStringFull(array));
        array.trim();
        ArrayUtils.revert(array);
        System.out.println(ArrayUtils.toStringFull(array));
    }
}
