package com.example.datastructure.heap.second;

public class Heap {

    protected int[] heap;
    protected int maxSize;
    protected int size;

    public Heap(final int maxSize, final int comparisionValue) {
        this.maxSize = maxSize;
        this.size=0;
        this.heap = new int[this.maxSize + 1];
        this.heap[0] = comparisionValue;
    }

    protected int getParent(int pos) {
        return pos / 2;
    }

    protected int getLeftChild(int pos) {
        return (pos * 2);
    }

    protected int getRightChild(int pos) {
        return (pos * 2) + 1;
    }

    protected boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    protected void swap(int fpos, int spos) {
        int temp;
        temp = this.heap[fpos];
        this.heap[fpos] = this.heap[spos];
        this.heap[spos] = temp;
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + this.heap[i]
                    + " LEFT CHILD : " + this.heap[2 * i]
                    + " RIGHT CHILD :" + this.heap[2 * i + 1]);
            System.out.println();
        }
    }
}
