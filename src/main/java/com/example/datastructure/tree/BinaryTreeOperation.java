package com.example.datastructure.tree;

import java.util.Stack;

public class BinaryTreeOperation {

    boolean checkBST(Tree root) {
        Stack<Tree> stack = new Stack<>();
        stack.push(root);

        while(true) {
            Tree temp = stack.pop();
            Tree left = temp.left;
            Tree right = temp.right;
            if (left != null && temp.data < left.data) {
                return false;
            } else if(right != null && temp.data > right.data) {
                return false;
            }

            if (left != null) stack.push(left);
            if (right != null) stack.push(right);

            if(stack.isEmpty()) {
                break;
            }


        }
        return true;
    }

    boolean checkBSTSecond(Tree root) {
        if(root == null) return true;

        Stack<Tree> stack = new Stack<>();
        stack.push(root);

        while(root != null) {

            root = stack.pop();

            if(root.left != null) {
                if(root.left.data > root.data) {
                    return false;
                }
                stack.push(root.left);
            }
            if(root.right != null) {
                if(root.right.data < root.data) {
                    return false;
                }
                stack.push(root.left);
            }

            if(stack.isEmpty()) {
                break;
            }

        }


        return true;

    }

    public int getMinValue(Tree root) {
        if (root.left != null) {
            return getMinValue(root.left);
        }
        return root.data;
    }

    public int getMaxValue(Tree root) {
        if (root.right != null) {
            return getMaxValue(root.right);
        }
        return root.data;
    }

    public Tree deleteNode(Tree root, int data) {
        if (root == null) return null;
        if (data < root.data) {
            root.setLeft(deleteNode(root.left, data));
        } else if (data > root.data) {
            root.setRight(deleteNode(root.right, data));
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                int minVal = getMinValue(root.right);
                root.setData(minVal);
                root.setRight(deleteNode(root.right, minVal));

            }

        }
        return root;
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
