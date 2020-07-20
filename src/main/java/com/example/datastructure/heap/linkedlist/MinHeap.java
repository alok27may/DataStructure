package com.example.datastructure.heap.linkedlist;

public class MinHeap {

    private Node head;

    public MinHeap(final int data) {
        head = new Node(data);
    }

    public void push(final int data) {
        Node curr = head;
        Node newNode = new Node(data);
        if (head.data > newNode.data) {
            newNode.next = head;
            head = newNode;
        } else {
            while (curr.next != null && curr.next.data < newNode.data) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }
    }

    public Node pop() {
        Node temp = head;
        head = head.next;
        return temp;
    }

    static class Node {
        int data;
        Node next;

        public Node(final int data) {
            this.data = data;
        }
    }

}
