package com.example.datastructure.heap.linkedlist;

class SolutionLeetCodeMergeKSortedList {

    public static void main(String[] args) {
        ListNode arr[] = new ListNode[3];

        arr[0] = new ListNode(1);
        arr[0].next = new ListNode(3);
        arr[0].next.next = new ListNode(5);
        arr[0].next.next.next = new ListNode(7);

        arr[1] = new ListNode(2);
        arr[1].next = new ListNode(4);
        arr[1].next.next = new ListNode(6);
        arr[1].next.next.next = new ListNode(8);

        arr[2] = new ListNode(0);
        arr[2].next = new ListNode(9);
        arr[2].next.next = new ListNode(10);
        arr[2].next.next.next = new ListNode(11);

        final ListNode listNode = mergeKLists(arr);
        System.out.println(listNode);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        for(int i = 0; i < lists.length; i++) {
            ListNode curr = lists[i];
            while(curr != null) {
                head = push(head, curr.val);
                curr = curr.next;
            }
        }

        return head;

    }


    public static ListNode push(ListNode head, final int val) {
        ListNode newNode = new ListNode(val);
        if(head == null) {
            return newNode;
        }
        ListNode curr = head;

        if (head.val > newNode.val) {
            newNode.next = head;
            head = newNode;
        } else {
            while (curr.next != null && curr.next.val < newNode.val) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }
        return head;
    }

    public ListNode pop(ListNode head) {
        ListNode temp = head;
        head = head.next;
        return temp;
    }

}
