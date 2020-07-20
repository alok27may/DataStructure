package com.example.datastructure.heap.second;

public class MinHeap extends Heap {
    private static final int FRONT = 1;

    public MinHeap(final int maxSize) {
        super(maxSize, Integer.MIN_VALUE);
    }

    public void insert(int element) {
        if (size >= maxSize) {
            return;
        }

        this.heap[++size] = element;

        int current = size;
        while (this.heap[current] < this.heap[getParent(current)]) {
            final int parent = getParent(current);
            swap(current, parent);
            current = parent;
        }
    }

    public void minHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    public int remove() {
        int popped = this.heap[FRONT];
        this.heap[FRONT] = this.heap[size--];
        minHeapify(FRONT);
        return popped;
    }

    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            int min = pos;
            final int leftChild = getLeftChild(pos);
            final int rightChild = getRightChild(pos);
            if (this.heap[leftChild] < this.heap[rightChild]) {
                min = leftChild;
            } else {
                min = rightChild;
            }

            if (this.heap[pos] > this.heap[min]) {
                swap(pos, min);
                minHeapify(min);
            }
        }
    }

}
