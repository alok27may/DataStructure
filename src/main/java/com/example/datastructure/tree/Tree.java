package com.example.datastructure.tree;

public class Tree {
    public int data;
    public Tree left;
    public Tree right;

    public Tree() {
    }

    public Tree(final int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(final int data) {
        this.data = data;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(final Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(final Tree right) {
        this.right = right;
    }
}
