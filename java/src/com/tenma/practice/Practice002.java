package com.tenma.practice;

import java.util.HashMap;
import java.util.List;

/**
 * probleam:
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * <p>
 * <p>
 * 题目：
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author tenma
 */
public class Practice002 {

    /**
     * Definition for singly-linked list.
     **/
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 链表相加
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            throw new IllegalArgumentException("Invalid paramter!");
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(0);
        ListNode curr = result;
        int rate = 0;
        do {
            int val;
            if (l1 == null) {
                val = l2.val;
            } else if (l2 == null) {
                val = l1.val;
            } else {
                val = l1.val + l2.val;
            }
            if (rate > 0) {
                val += 1;
            }
            if (val >= 10) {
                curr.next = new ListNode(val % 10);
                rate = 1;
            } else {
                curr.next = new ListNode(val);
                rate = 0;
            }
            curr = curr.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        } while (l1 != null || l2 != null);
        if (rate > 0) {
            curr.next = new ListNode(rate);
        }
        return result.next;
    }


    public static void main(String[] args) {

        Practice002 practice002 = new Practice002();
        ListNode l1 = practice002.new ListNode(2);
        l1.next = practice002.new ListNode(4);
        l1.next.next = practice002.new ListNode(3);

        ListNode l2 = practice002.new ListNode(5);
        l2.next = practice002.new ListNode(6);
        l2.next.next = practice002.new ListNode(4);
        ListNode listNode = practice002.addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val);
            System.out.print("->");
            listNode = listNode.next;
        }
    }
}