package com.example.datastructure.tree;

public class BSTOperation {

    private static Tree root;
    private static BinarySearchTree binarySearchTree;

    static {
        binarySearchTree = new BinarySearchTree();
        buildBinarySearchTree();
    }

    private static void buildBinarySearchTree() {
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
//        System.out.println("Is a BST :: " + binarySearchTree.checkBST(root));
//        System.out.println("Is a BST :: " + binarySearchTree.checkBSTSecond(root));
        Tree tree = buildTree();
        System.out.println(binarySearchTree.bstToGst(tree));
//        System.out.println("Min Value of BST :: " + binaryTreeOperation.getMinValue(root));
//        System.out.println("Max Value of BST :: " + binaryTreeOperation.getMaxValue(root));

//        final Tree tree = binaryTreeOperation.deleteNode(root, 6);
//        System.out.println();

//        binaryTreeOperation.insertNode(root, 4);
//        new TreeOperation().preOrder(root);

    }

    private static Tree buildTree() {
        Tree tree = new Tree(4);

        final Tree left = new Tree(1);
        left.setLeft(new Tree(0));
        final Tree right1 = new Tree(2);
        right1.setRight(new Tree(3));
        left.setRight(right1);

        final Tree right = new Tree(6);
        right.setLeft(new Tree(5));
        final Tree right2 = new Tree(7);
        right2.setRight(new Tree(8));
        right.setRight(right2);

        tree.setLeft(left);
        tree.setRight(right);
        return tree;
    }
}
