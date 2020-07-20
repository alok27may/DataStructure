package com.example.datastructure.utility;

public final class ArraysUtility {


    public static void print(final int[] outputSorted) {
        System.out.print("[ ");
        printRawArray(outputSorted);
        System.out.println("]");
    }

    public static void print(final int[] array, final String prefix) {
        System.out.print(StringsUtility.isEmpty(prefix) ? "" : prefix);
        print(array);
    }

    public static void print(int[][] array) {
        System.out.print("[");
        for(int i=0; i < array.length; i++) {
            System.out.print("{ ");
            printRawArray(array[i]);
            System.out.print("}");
            if (i != array.length -1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

    }

    private static void printRawArray(final int[] outputSorted) {
        for (int i = 0; i < outputSorted.length; i++) {
            System.out.print(outputSorted[i] + " ");
        }
    }
}
