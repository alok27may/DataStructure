package com.example.datastructure.linklist;

public class MyLinkedList {
    public Node head;

    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node node) {
            next = node;
        }
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node cur = head;
        int curIndex = 0;
        while(cur != null) {
            if(curIndex == index) {
                return cur.getData();
            }
            cur = cur.getNext();
            curIndex++;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.setNext(head);
        head = newNode;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(head == null) {
            head = new Node(val);
            return;
        }
        Node cur = head;
        while(cur.getNext() != null) {
            cur = cur.getNext();
        }

        Node newNode = new Node(val);
        cur.setNext(newNode);

    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index == 0) {
            addAtHead(val);
            return;
        }
        Node cur = head;
        int curIndex = 0;
        while(cur.getNext() != null && ++curIndex != index) {
            cur = cur.getNext();
        }

        if(curIndex == index || curIndex == index-1 ) {
            Node newNode = new Node(val);
            newNode.setNext(cur.getNext());
            cur.setNext(newNode);
        }


    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index == 0) {
            head = head.getNext();
            return;
        }
        Node cur = head;
        int curIndex = 0;
        while(cur.getNext() != null && ++curIndex != index) {
            cur = cur.getNext();
        }
        if(curIndex != index) {
            return;
        }

        cur.setNext(cur.getNext().getNext());
    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(7);
        obj.addAtHead(2);
        obj.addAtHead(1);

        obj.addAtIndex(3, 0);
        obj.deleteAtIndex(2);

        obj.addAtHead(6);
        obj.addAtTail(4);
        final int output = obj.get(4);
        obj.addAtHead(4);
        obj.addAtIndex(5,0);
        obj.addAtHead(6);


    }
}

