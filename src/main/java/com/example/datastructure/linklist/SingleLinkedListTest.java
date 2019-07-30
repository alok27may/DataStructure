package com.example.datastructure.linklist;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Assert;
import org.junit.Test;

public class SingleLinkedListTest {

    @Test
    public void shouldAddElement() {
        int length = 10;
        SingleLinkedList sLL = createSingleLinkedList(length);
        sLL.add(5);

        Assert.assertEquals(length + 1, sLL.size());
    }

    @Test
    public void shouldAddElementAtLast() {
        int length = 10;
        SingleLinkedList sLL = createSingleLinkedList(length);
        sLL.addAtLast(5);

        Assert.assertEquals(length + 1, sLL.size());
    }

    @Test
    public void shouldAddElementAtFirst() {
        SingleLinkedList sLL = createSingleLinkedList(10);
        int firstElement = 5;
        sLL.addAtFirst(firstElement);
        Assert.assertEquals(firstElement, sLL.getFirstElement());
    }

    @Test
    public void shouldReturnFirstElement() {
        int data = RandomUtils.nextInt();
        SingleLinkedList sLL = new SingleLinkedList(data);
        Assert.assertEquals(data, sLL.getFirstElement());
    }

    @Test
    public void shouldReturnLastElement() {
        SingleLinkedList sLL = createSingleLinkedList(10);
        int lastElement = RandomUtils.nextInt();
        sLL.addAtLast(lastElement);
        Assert.assertEquals(lastElement, sLL.getLastElement());
    }

    @Test
    public void shouldReturnSize() {
        int length = 10;
        SingleLinkedList sLL = createSingleLinkedList(length);
        Assert.assertEquals(length, sLL.size());
    }

    @Test
    public void shouldAddElementAtFixedPosition() {
        int length = 10;
        SingleLinkedList sLL = createSingleLinkedList(length);
        final int position = RandomUtils.nextInt(length - 1);
        int data = RandomUtils.nextInt();
        sLL.addAtPosition(data, position);

        System.out.println("Data Details");
        sLL.printSingleLinkedList();
        System.out.println(position);

        Assert.assertEquals(data, sLL.getElementAtPosition(position));
    }

    private SingleLinkedList createSingleLinkedList(final int length) {
        SingleLinkedList sLL = new SingleLinkedList(RandomUtils.nextInt());
        for (int i = 1; i< length; i++) {
            sLL.add(RandomUtils.nextInt());
        }
        return sLL;
    }

    @Test
    public void findInteractionNode() {
        SingleLinkedList firstLL = new SingleLinkedList(1);
        firstLL.add(83);
        firstLL.add(44);
        firstLL.add(39);
        firstLL.add(95);
        firstLL.add(100);

//        5 83 44 39 95 100
//        8 35 97 71 32 13 11 12 15
//        10 36 1 94 100 70 83 78 34 59 79

        SingleLinkedList secondLL = new SingleLinkedList(9);
        secondLL.add(11);
        secondLL.add(12);
        secondLL.add(13);
        secondLL.add(14);

        SingleLinkedList.Node intersectionNode = firstLL.getIntersectionNode(secondLL);
        System.out.println(intersectionNode.getData());
        System.out.println(intersectionNode.getNext());


    }

    @Test
    public void reverseList() {
        SingleLinkedList firstLL = new SingleLinkedList(1);
        firstLL.add(83);
        firstLL.add(44);
        firstLL.add(39);
        firstLL.add(95);
        firstLL.add(100);

        SingleLinkedList.Node node = firstLL.reverseList();
        System.out.println(node);


    }

    @Test
    public void palindromeList() {
        SingleLinkedList firstLL = new SingleLinkedList(5);
        firstLL.add(2);
        firstLL.add(5);
        firstLL.add(2);
        firstLL.add(5);

        boolean palindrome = firstLL.isPalindrome();
        System.out.println(palindrome);

    }

    @Test
    public void deleteDuplicate() {
        SingleLinkedList firstLL = new SingleLinkedList(5);
        firstLL.add(2);
        firstLL.add(2);
        firstLL.add(2);
        firstLL.add(5);
        firstLL.add(5);

        SingleLinkedList.Node node = firstLL.deleteDuplicate();
        System.out.println(node);

    }

    @Test
    public void uniqueList() {
        SingleLinkedList firstLL = new SingleLinkedList(5);
        firstLL.add(2);
        firstLL.add(2);
        firstLL.add(2);
        firstLL.add(5);
        firstLL.add(5);
        firstLL.add(5);
        firstLL.add(5);
        firstLL.add(5);
        firstLL.add(5);
        firstLL.add(5);
        firstLL.add(5);
        firstLL.add(7);
        firstLL.add(7);
        firstLL.add(7);
        firstLL.add(7);
        firstLL.add(7);
        firstLL.add(7);
        firstLL.add(7);
        firstLL.add(7);
        firstLL.add(7);
        firstLL.add(11);

        int i = RandomUtils.nextInt(10);
        System.out.println(i);

//        SingleLinkedList.Node node = firstLL.uniqueList();
//        System.out.println(node);

    }

//    public ListNode deleteDuplicates(ListNode A) {
//        if(A==null)
//            return A;
//        ListNode curr = A, prev = null, next;
//        ListNode newList = new ListNode(-1), new_head = newList;
//        while(curr!=null) {
//            next = curr.next;
//            if(!((prev!=null && curr.val==prev.val) || (next!=null && curr.val==next.val))) {
//                ListNode n = new ListNode(curr.val);
//                newList.next = n;
//                newList = n;
//            }
//            prev = curr;
//            curr = next;
//        }
//        return new_head.next;
//    }




}
