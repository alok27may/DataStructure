package com.example.datastructure.heap.second;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MaxHeap {
    private int capacity;
    private int size = 0;
    private int[] heap;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
    }

    public static MaxHeap createMaxHeap(final int[] nums) {
        MaxHeap heap = new MaxHeap(nums.length);
        for(int i=0; i<nums.length; i++) {
            heap.add(nums[i]);
        }
        return heap;
    }


    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int parentIndex) {
        return heap[getLeftChildIndex(parentIndex)];
    }

    private int rightChild(int parentIndex) {
        return heap[getRightChildIndex(parentIndex)];
    }

    private int parent(int childIndex) {
        return heap[getParentIndex(childIndex)];
    }

    private void swap(int index1, int index2) {
        int element = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = element;
    }

    // Time Complexity : O( Log n)
    public void add(int item) {
        ensureCapacity();
        heap[size] = item;
        size++;
        heapifyUp();
    }

    private void ensureCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity = capacity * 2;
        }
    }

    // Time Complexity : O(1)
    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return heap[0];
    }

    // Time Complexity : O( Log n)
    public void poll() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int element = heap[0];

        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
    }

    private void heapifyDown() {
        int index = 0;

        while (hasLeftChild(index)) {
            int greatestChildIndex = getLeftChildIndex(index);

            if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
                greatestChildIndex = getRightChildIndex(index);
            }

            if (heap[index] < heap[greatestChildIndex]) {
                swap(index, greatestChildIndex);
            } else {
                break;
            }
            index = greatestChildIndex;
        }
    }

    private void heapifyUp() {
        int index = size - 1;

        while (hasParent(index) && parent(index) < heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public int findKthLargest(int k) {
        for(int j = 1; j < k; j++) {
            poll();
        }
        return peek();

    }

    public MaxHeap createMaxHeapFromArray(final int[] nums) {
        MaxHeap heap = new MaxHeap(nums.length);
        for(int i=0; i<nums.length; i++) {
            heap.add(nums[i]);
        }
        return heap;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
