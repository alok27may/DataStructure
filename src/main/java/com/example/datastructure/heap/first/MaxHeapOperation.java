package com.example.datastructure.heap.first;

import com.example.datastructure.utility.ArraysUtility;

public class MaxHeapOperation {
    public static void main(String[] args) {
        int[] input = new int[] { 3, 2, 1, 5, 6, 4};
        ArraysUtility.print(input, "Input : ");
        final MaxHeap maxHeap = MaxHeap.createMaxHeap(input);
        maxHeap.printHeap();

        final int kthElement = 3;
        System.out.println(kthElement + "th Largest :: " + maxHeap.findKthLargest(kthElement));

    }

}
