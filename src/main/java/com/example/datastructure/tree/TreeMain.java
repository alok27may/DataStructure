package com.example.datastructure.tree;

public class TreeMain {

    private static Tree root;
    private static TreeOperation treeOperation;

    static {
        treeOperation = new TreeOperation();
        buildTree();
    }

    private static void buildTree() {
        root = new Tree(1);

        final Tree left = new Tree(2);
        left.setLeft(new Tree(4));
        left.setRight(new Tree(5));

        final Tree right = new Tree(3);
        right.setLeft(new Tree(6));
        right.setRight(new Tree(7));

        root.setLeft(left);
        root.setRight(right);
    }

    public static void main(String[] args) {
        traverseAllOrder();

        System.out.println("\nHeight of Tree :: " + treeOperation.heightOfTree(root));
        System.out.println("\nHeight of Tree Second Approach  :: " + treeOperation.getHeight(root));
        System.out.println("\nHeight of Tree Without Recursive :: " + treeOperation.getHeightWithoutRecursive(root));

        System.out.print("Top View Using Stack : ");
        treeOperation.topTreeView(root);
        System.out.println();
        System.out.print("Top View Using Recursion : ");
        treeOperation.topViewByRecursion(root);

    }

    private static void traverseAllOrder() {
        System.out.println("Pre Order Data");
        treeOperation.preOrder(root);
        System.out.println("\nIn Order Data");
        treeOperation.inOrder(root);
        System.out.println("\nPost Order Data");
        treeOperation.postOrder(root);

        System.out.println("\nLevle Order Data");
        treeOperation.levelOrderTraverse(root);

        System.out.println("\nPre Order Data Using Non Recursive");
        treeOperation.preOrderNonRecursive(root);
    }
}
