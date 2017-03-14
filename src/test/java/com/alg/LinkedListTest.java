package com.alg;

import org.testng.annotations.Test;

import com.alg.list.LinkedList;
import com.alg.list.ListNode;

public class LinkedListTest {

    private ListNode linkList = buildLinkList();

    public ListNode buildLinkList() {
        ListNode head = null, curNode = null;
        for (int i = 0; i < 10; i++) {
            ListNode node = new ListNode(i);
            if (null == head) {
                head = node;
                curNode = node;
            } else {
                curNode.setNext(node);
                curNode = node;
            }
        }
        return head;
    }

    @Test
    public void testReversedList() {
        ListNode list = linkList;
        printList(list);
        printList(LinkedList.reverse(list));
    }

    private void printList(ListNode node) {
        while (null != node) {
            System.out.println(node.getVal());
            node = node.getNext();
        }
    }
}
