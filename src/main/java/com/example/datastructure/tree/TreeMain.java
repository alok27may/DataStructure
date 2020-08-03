package com.example.datastructure.tree;

public class TreeMain {

    private static Tree root = buildTree();
    private static TreeOperation treeOperation = new TreeOperation();

    public static void main(String[] args) {
        traverseAllOrder();
        heightOfTree();
        topViewOfTree();

        System.out.println("No of Leaf node in tree :: " + treeOperation.numberOfLeafNode(root));
        System.out.println("Increasing BST :: " + treeOperation.increasingBST(root));
        System.out.println("Inverted Tree :: " + treeOperation.invertTree(root));
    }

    private static void topViewOfTree() {
        System.out.print("Top View Using Stack : ");
        treeOperation.topTreeView(root);
        System.out.println();
        System.out.print("Top View Using Recursion : ");
        treeOperation.topViewByRecursion(root);
        System.out.println();
    }

    private static void heightOfTree() {
        System.out.println("\nHeight of Tree :: " + treeOperation.heightOfTree(root));
        System.out.println("\nHeight of Tree Second Approach  :: " + treeOperation.getHeight(root));
        System.out.println("\nHeight of Tree Without Recursive :: " + treeOperation.getHeightWithoutRecursive(root));
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

    private static Tree buildTree() {
        root = new Tree(1);

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
