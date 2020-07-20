package com.example.datastructure.heap.first;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap {
    private int capacity;
    private int size = 0;
    private int[] heap;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
    }

    public static MinHeap createMinHeap(final int[] nums) {
        MinHeap heap = new MinHeap(nums.length);
        for(int i=0; i<nums.length; i++) {
            heap.add(nums[i]);
        }
        return heap;
    }

    public int getSize() {
        return size;
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
            int smallestChildIndex = getLeftChildIndex(index);

            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallestChildIndex = getRightChildIndex(index);
            }

            if (heap[index] > heap[smallestChildIndex]) {
                swap(index, smallestChildIndex);
            } else {
                break;
            }
            index = smallestChildIndex;
        }
    }

    private void heapifyUp() {
        int index = size - 1;

        while (hasParent(index) && parent(index) > heap[index]) {
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

    public MinHeap createMinHeapFromArray(final int[] nums) {
        MinHeap heap = new MinHeap(nums.length);
        for(int i=0; i<nums.length; i++) {
            heap.add(nums[i]);
        }
        return heap;
    }

    public void printHeap() {
        System.out.print(getClass().getSimpleName() + " : ");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
