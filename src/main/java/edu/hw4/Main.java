package edu.hw4;

public class Main {
    public static void main(String[] args) {
        ArraySlice<Double> array = ArraySlice.ofRange(new Double[] {1.0, -1.0, 2.0, 1.0, 1.0, 4.0, 5.0, 8.0, 6.0}, 2, 6);
        System.out.println(array);

        ArrayUtils.duplicate(array, 1.0);
        ArrayUtils.sort(array);
        System.out.println(array.toStringFull());
        array.trim();
        ArrayUtils.revert(array);
        System.out.println(array.toStringFull());
    }
}
