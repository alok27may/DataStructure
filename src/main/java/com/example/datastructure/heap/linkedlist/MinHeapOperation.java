package com.example.datastructure.heap.linkedlist;

public class MinHeapOperation {
    public static void main(String[] args) {
        final MinHeap minHeap = new MinHeap(6);
        minHeap.push(5);
        minHeap.push(8);
        minHeap.push(3);
        minHeap.push(2);
        minHeap.push(9);
        minHeap.push(1);

        System.out.println(minHeap.pop().data);
        System.out.println(minHeap.pop().data);
    }
}
