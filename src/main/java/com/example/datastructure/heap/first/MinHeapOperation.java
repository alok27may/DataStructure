package com.example.datastructure.heap.first;

import com.example.datastructure.utility.ArraysUtility;

public class MinHeapOperation {
    public static void main(String[] args) {
        // create Min Heap
        final int[] input = new int[] { 3, 2, 1, 5, 6, 4};
        ArraysUtility.print(input, "Input : ");
        final MinHeap minHeap = MinHeap.createMinHeap(input);
        minHeap.printHeap();

        // Get Kth largest element of min Heap
        final int kthElement = 5;
        System.out.println(kthElement + "th Largest :: " + minHeap.findKthLargest(kthElement));

        //Merged sorted array in single array using Min Heap
        final int[][] sortedArray = getSortedArray();
        ArraysUtility.print(sortedArray);
        final int[] outputSorted = mergeSortedArray(sortedArray);
        ArraysUtility.print(outputSorted, "Sorted Arrays : ");


    }

    private static int[][] getSortedArray() {
        return new int[][] {
                {1, 3, 5, 7},
                {2, 4, 6, 8, 12, 15},
                {0, 9, 10, 11, 19}
        };
    }

    private static int[] mergeSortedArray(int[][] array) {
        MinHeap heap = new MinHeap(array.length * array[0].length);
        for(int i=0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    heap.add(array[i][j]);
                }
            }
        }

        final int[] mergeSorted= new int[heap.getSize()];

        for (int i = 0; i < mergeSorted.length; i++) {
            mergeSorted[i] = heap.peek();
            heap.poll();
        }
        return mergeSorted;
    }



}
