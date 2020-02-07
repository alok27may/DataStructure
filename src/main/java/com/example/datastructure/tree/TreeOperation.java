package com.example.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeOperation {

    public void preOrder(final Tree root) {
        if (root != null) {
            System.out.print(root.getData());
            System.out.print(" ");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public void inOrder(final Tree root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getData());
            System.out.print(" ");
            inOrder(root.getRight());
        }
    }

    public void postOrder(final Tree root) {
        if (root == null) return;
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getData());
        System.out.print(" ");
    }

    public void preOrderNonRecursive(final Tree tree) {
        Tree root = tree;
        if (root == null) return;
        Stack<Tree> stack = new Stack();
        while (true) {
            while (root != null) {
                System.out.print(root.getData());
                System.out.print(" ");
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            root = root.getRight();
        }
        stack = null;
    }

    public int heightOfTree(final Tree tree) {
        if (tree == null) {
            return 0;
        } else {
            final int hLeft = heightOfTree(tree.getLeft());
            final int hRight = heightOfTree(tree.getRight());
            if (hLeft > hRight) {
                return (hLeft + 1);
            } else {
                return (hRight + 1);
            }
        }
    }

    public int getHeight(Tree root){
        if( root == null) return 0;
        return 1 + Math.max(getHeight(root.getLeft()), getHeight(root.getRight()));
    }

    public void levelOrderTraverse(Tree root) {
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.print(root.getData());
            System.out.print(" ");
            if (root.getLeft() == null || root.getRight() == null)  continue;
            queue.add(root.getLeft());
            queue.add(root.getRight());

        }
        queue = null;
    }

    public void topTreeView(Tree root) {
        Tree temp = root;
        Stack<Tree> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.getLeft();
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().getData());
            System.out.print(" ");
        }

        root = root.getRight();
        while (root != null) {
            System.out.print(root.getData());
            System.out.print(" ");
            root = root.getRight();
        }
    }

    public void topViewByRecursion(Tree root)
    {
        print_left(root.getLeft());

        System.out.print(root.getData());
        System.out.print(" ");

        print_right(root.getRight());
    }

    private void print_left(Tree root){
        if(root.getLeft() != null){
            print_left(root.getLeft());
        }

        System.out.print(root.getData());
        System.out.print(" ");
    }

    private void print_right(Tree root){
        System.out.print(root.getData());
        System.out.print(" ");

        if(root.getRight() != null){
            print_right(root.getRight());
        }
    }

    public static Tree insertNode(Tree root,int data) {
        if (root == null) {
            root = new Tree(data);
        } else {
            if (data < root.data) {
                root.setLeft(insertNode(root.left, data));
            } else if (data > root.data) {
                root.setRight(insertNode(root.right, data));
            }
        }
        return root;

    }

}
