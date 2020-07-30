package com.example.datastructure.linklist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SingleLinkedList {

    private Node head;

    public Node getHead() {
        return head;
    }

    public SingleLinkedList(final int data) {
        head = new Node(data);
    }

    public void add(final int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
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
        Node currentNode = head;
        Node next = null;
        Node prev = null;
        while(currentNode != null) {
            next = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;
        }
        head = prev;
        return prev;
    }

    public Node reverseAndClone(Node head) {
        Node reverseHead = null;
        while(head != null) {
            Node newNode = new Node(head.data);
            newNode.next = reverseHead;
            reverseHead = newNode;
            head = head.next;
        }
        return reverseHead;
    }

public Node reverseListByKthNumber(Node node, int position) {
        Node currentNode = node;
        Node next = null;
        Node prev = null;
        int count = 0;
        while(count < position && currentNode != null) {
            next = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;
            count++;
        }
        if (next != null) {
            node.next = reverseListByKthNumber(next, position);
        }
        return prev;
    }

    public Node reverseByExactKthNumberOrNot(Node node, int k) {
        return reverseByExactKthNumberOrNot(node, k, size());
    }

    private Node reverseByExactKthNumberOrNot(final Node node, final int k, final int size) {
        if (size < k) {
            return node;
        }
        Node curr = node;
        Node next = null;
        Node prev = null;
        int count = 0;
        while(count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (next != null) {
            node.next = reverseByExactKthNumberOrNot(next, k, size - k);
        }
        return prev;
    }

    public boolean isPalindrome() {
        Node currentReverse = reverseAndClone(head);
        Node current = head;
        while (current != null && currentReverse != null) {
            if (currentReverse.getData() != current.getData()) {
                return false;
            }
            current = current.next;
            currentReverse = currentReverse.next;

        }
        return current == null && currentReverse == null;
    }

    public boolean isPalindromeRunnerApproach() {
        Stack<Integer> stack = new Stack<>();
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.data != stack.pop()) {
                return false;
            }
            slow = slow.next;
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

    public boolean hasCycle(SingleLinkedList list) {
        Node slow = list.head;
        Node fast = list.head;

        while(fast != null && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

    public Node detectCycle(SingleLinkedList list) {
        Node slow = list.head;
        Node fast = list.head;
        boolean result = false;

        while(fast != null && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                result = true;
                break;
            }
        }

        if (result) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }

        return null;
    }

    public int lengthOfCycle(SingleLinkedList list) {
        Node slow = list.head;
        Node fast = list.head;
        boolean result = false;

        while(fast != null && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                result = true;
                break;
            }
        }

        int count = 0;

        if (result) {
            fast = fast.next;
            while (slow != fast) {
                fast = fast.next;
                count++;
            }
        }

        return count;
    }

    public Node middleNode(SingleLinkedList list) {
        Node slow = list.head;
        Node fast = list.head;

        while(fast != null && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static int findMergeNode(SingleLinkedList list1, SingleLinkedList list2) {
        int firstLength = 1, secondLength = 1;
        Node firstCurrNode = list1.head, secondCurrNode = list2.head;
        while(firstCurrNode.next != null) {
            firstLength++;
            firstCurrNode = firstCurrNode.next;
        }

        while(secondCurrNode.next != null) {
            secondLength++;
            secondCurrNode = secondCurrNode.next;
        }


        int diff = 0;
        if(firstLength > secondLength) {
            firstCurrNode = list1.head;
            secondCurrNode = list2.head;
            diff = firstLength - secondLength;
        } else {
            firstCurrNode = list2.head;
            secondCurrNode = list1.head;
            diff = secondLength - firstLength;
        }

        for(int i = 0; i < diff; i++) {
            firstCurrNode = firstCurrNode.next;
        }

        while(firstCurrNode != null && secondCurrNode != null) {
            if(firstCurrNode.data == secondCurrNode.data) {
                return firstCurrNode.data;
            }
            firstCurrNode = firstCurrNode.next;
            secondCurrNode = secondCurrNode.next;
        }

        return 0;
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
