package com.company;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 等分割一个List为两个
        ListNode mid = findMidNode(head);
        ListNode midHead = mid.next;
        mid.next = null;

        return mergeTwoList(sortList(head), sortList(midHead));
    }

    public ListNode findMidNode(ListNode head) {
        if (head.next == null || head == null) {
            //空或只有一个
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 合并两个List
    public ListNode mergeTwoList(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        // newHead是合并后的头节点 res是合并过程中的行动节点
        ListNode res, newHead;
        ListNode leftHead = left, rightHead = right;
        if (left.val <= right.val) {
            newHead = res = left;
            leftHead = left.next;
        } else {
            newHead = res = right;
            rightHead = right.next;
        }
        while (leftHead != null || rightHead != null) {
            if (leftHead == null) {
                // 第一条链表为空
                res.next = rightHead;
                return newHead;
            } else if (rightHead == null) {
                // 第二条链表为空
                res.next = leftHead;
                return newHead;
            } else if (leftHead.val <= rightHead.val) {
                // 第二条链表头节点值更小
                res.next = leftHead;
                leftHead = leftHead.next;
                res = res.next;
            } else {
                // 第二条链表头节点值更小
                res.next = rightHead;
                rightHead = rightHead.next;
                res = res.next;
            }
        }
        return newHead;
    }
}
