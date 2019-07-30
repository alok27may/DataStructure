package com.example.datastructure.linklist;

import java.util.ArrayList;
import java.util.List;

public class SingleLinkedList {

    private Node head;


    public SingleLinkedList(final int data) {
        head = new Node(data);
    }

    public void add(final int data) {
        final Node insertSLL = new Node(data);
        Node currentElement = head;
        while (currentElement.getNext() != null) {
            currentElement = currentElement.getNext();
        }
        currentElement.setNext(insertSLL);
    }

    public void addAtLast(final int data) {
        add(data);
    }

    public void addAtFirst(final int data) {
        final Node insertSLL = new Node(data);
        insertSLL.setNext(head);
        head = insertSLL;
    }

    public int getFirstElement() {
        return head.data;
    }

    public int getLastElement() {
        Node currentElement = head;
        while (currentElement.getNext() != null) {
            currentElement = currentElement.getNext();
        }
        return currentElement.data;
    }

    public void addAtPosition(final int data, final int position) {
        if (position <= 0) throw new IllegalArgumentException("Position can't be less and equal to zero");
        if (position == 1) {
            addAtFirst(data);
            return;
        }
        int currentPosition = 1;
        final Node insertSLL = new Node(data);
        Node currentElement = head;
        while (currentElement.getNext() != null && ++currentPosition != position) {
            currentElement = currentElement.getNext();
        }
        insertSLL.setNext(currentElement.getNext());
        currentElement.setNext(insertSLL);
    }

    public int getElementAtPosition(final int position) {
        int currentPosition = 1;
        Node currentElement = head;
        while (currentElement.getNext() != null && currentPosition++ != position) {
            currentElement = currentElement.getNext();
        }
        return currentElement.getData();
    }

    public void deleteFirstElement() {
        head = head.getNext();
    }

    public void deleteLastElement() {
        Node currentElement = head;
        while (currentElement.getNext().getNext() != null) {
            currentElement = currentElement.getNext();
        }
        currentElement.next = null;
    }

    public void deleteElementAtPosition(final int position) {

    }


    public int size() {
        int size = 0;
        Node currentElement = head;
        while (currentElement != null) {
            size++;
            currentElement = currentElement.getNext();
        }
        return size;
    }

    public void printSingleLinkedList() {
        Node currentElement = head;
        while (currentElement != null) {
            System.out.println(currentElement.getData());
            currentElement = currentElement.getNext();
        }
    }

    public Node getIntersectionNode(SingleLinkedList b) {
        int aLength = this.size();
        int bLength = b.size();

        if (bLength > aLength) {
            return findInteractionNode(this, b, aLength, bLength);
        } else {
            return findInteractionNode(b, this, bLength, aLength);
        }

    }

    private Node findInteractionNode(SingleLinkedList a, SingleLinkedList b, int aLength, int bLength) {
        int diffLength = bLength - aLength;
        Node sB = b.head;
        Node sA = a.head;
        while(diffLength != 0) {
            sB = sB.next;
            diffLength--;
        }
        int limit = aLength;
        while(limit != 0) {
            if(sA.data == sB.data) {
                return sA;
            }
            sA = sA.next;
            sB = sB.next;
            limit--;
        }
        return null;
    }

    public Node reverseList() {
        Node reversedNode = new Node(head.data);
        Node currentNode = head;
        while(currentNode.next != null) {
            Node tempNode = new Node(currentNode.next.data);
            tempNode.next = reversedNode;
            reversedNode = tempNode;
            currentNode = currentNode.next;
        }
        return reversedNode;
    }

    public boolean isPalindrome() {
        Node B = reverseList();
        Node currentANode = head;
        Node currentBNode = B;
        while (currentANode.next != null) {
            if (currentBNode.getData() != currentANode.getData()) {
                return false;
            }
            currentANode = currentANode.next;
            currentBNode = currentBNode.next;

        }
        return true;
    }

    public Node deleteDuplicate() {
        Node cn = head;
        while(cn.next != null) {
            if(cn.getData() == cn.next.getData()) {
                if (cn.next.next != null) {
                    cn.next = cn.next.next;
                    continue;
                } else {
                    cn.next = null;
                    break;
                }
            }
            cn = cn.next;
        }
        return head;
    }

    public Node uniqueList() {
        List<Integer> integers = new ArrayList<>();
        List<Integer> integers1 = new ArrayList<>();
        Node cn = head;
        while(cn.next != null) {
            if (integers.contains(cn.data)) {
                integers1.remove(new Integer(cn.data));
            } else {
                integers.add(cn.data);
                integers1.add(cn.data);
            }
            cn = cn.next;
        }

        SingleLinkedList singleLinkedList = new SingleLinkedList(integers.get(0));
        for (int i1 = 1; i1 < integers1.size(); i1++) {
            final Integer i = integers1.get(i1);
            singleLinkedList.add(i);
        }

        return singleLinkedList.head;
    }

    class Node {

        private int data;
        private Node next;

        public Node(final int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(final int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(final Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "head=" + head +
                '}';
    }


}
