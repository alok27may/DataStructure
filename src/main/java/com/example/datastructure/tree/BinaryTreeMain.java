package com.example.datastructure.tree;

public class BinaryTreeMain {

    private static Tree root;
    private static BinaryTreeOperation binaryTreeOperation;

    static {
        binaryTreeOperation = new BinaryTreeOperation();
        buildBinaryTree();
    }

    private static void buildBinaryTree() {
        root = new Tree(7);

        final Tree left = new Tree(5);
        left.setLeft(new Tree(3));
        left.setRight(new Tree(6));

        final Tree right = new Tree(8);
        right.setLeft(new Tree(7));
        right.setRight(new Tree(9));

        root.setLeft(left);
        root.setRight(right);
    }

    public static void main(String[] args) {
        System.out.println("Is a BST :: " + binaryTreeOperation.checkBST(root));
        System.out.println("Is a BST :: " + binaryTreeOperation.checkBSTSecond(root));
//        System.out.println("Min Value of BST :: " + binaryTreeOperation.getMinValue(root));
//        System.out.println("Max Value of BST :: " + binaryTreeOperation.getMaxValue(root));

//        final Tree tree = binaryTreeOperation.deleteNode(root, 6);
//        System.out.println();

//        binaryTreeOperation.insertNode(root, 4);
//        new TreeOperation().preOrder(root);

    }
}
