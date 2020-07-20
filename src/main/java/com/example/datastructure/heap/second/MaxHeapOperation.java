package com.example.datastructure.heap.second;

public class MaxHeapOperation {
    public static void main(String[] args) {
        int[] input = new int[] { 3, 2, 1, 5, 6, 4};
        final MaxHeap maxHeap = MaxHeap.createMaxHeap(input);
        maxHeap.printHeap();

        final int kthElement = 3;
        System.out.println(kthElement + "th Largest :: " + maxHeap.findKthLargest(kthElement));

    }


}
