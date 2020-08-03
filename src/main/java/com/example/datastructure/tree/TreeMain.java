package com.example.datastructure.tree;

public class TreeMain {

    private static TreeOperation treeOperation = new TreeOperation();

    public static void main(String[] args) {
        traverseAllOrder();
        heightOfTree();
        topViewOfTree();
        invertTree();

        System.out.println("No of Leaf node in tree :: " + treeOperation.numberOfLeafNode(buildTree()));
        System.out.println("Increasing BST :: " + treeOperation.increasingBST(buildTree()));
    }

    private static void invertTree() {
        System.out.println("Inverted Tree :: " + treeOperation.invertTree(buildTree()));
        System.out.println("Inverted Tree Recursive :: " + treeOperation.invertTreeRecursive(buildTree()));
    }

    private static void topViewOfTree() {
        System.out.print("Top View Using Stack : ");
        treeOperation.topTreeView(buildTree());
        System.out.println();
        System.out.print("Top View Using Recursion : ");
        treeOperation.topViewByRecursion(buildTree());
        System.out.println();
    }

    private static void heightOfTree() {
        System.out.println("\nHeight of Tree :: " + treeOperation.heightOfTree(buildTree()));
        System.out.println("\nHeight of Tree Second Approach  :: " + treeOperation.getHeight(buildTree()));
        System.out.println("\nHeight of Tree Without Recursive :: " + treeOperation.getHeightWithoutRecursive(buildTree()));
    }

    private static void traverseAllOrder() {
        System.out.println("Pre Order Data");
        treeOperation.preOrder(buildTree());
        System.out.println("\nIn Order Data");
        treeOperation.inOrder(buildTree());
        System.out.println("\nPost Order Data");
        treeOperation.postOrder(buildTree());

        System.out.println("\nLevle Order Data");
        treeOperation.levelOrderTraverse(buildTree());

        System.out.println("\nPre Order Data Using Non Recursive");
        treeOperation.preOrderNonRecursive(buildTree());
    }

    private static Tree buildTree() {
        Tree root = new Tree(1);

        final Tree left = new Tree(2);
        left.setLeft(new Tree(4));
        left.setRight(new Tree(5));

        final Tree right = new Tree(3);
        right.setLeft(new Tree(6));
        right.setRight(new Tree(7));

        root.setLeft(left);
        root.setRight(right);
        return root;
    }
}
