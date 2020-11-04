package com.company;

import com.company.base.ListNode;

/**
 * @description: 将给定的单链表L： L 0→L 1→…→L n-1→L n,
 * 重新排序为： L 0→L n →L 1→L n-1→L 2→L n-2→…
 * 要求使用原地算法，并且不改变节点的值
 * 例如：
 * 对于给定的单链表{1,2,3,4}，将其重新排序为{1,4,2,3}.
 * @author: Mask
 * @time: 2020/5/6 5:38 下午
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // 快慢步，找到链表中间点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 从中间点切断链表
        ListNode after = slow.next;
        slow.next = null;

        // 反转after为头结点的后半段链表,反转后pre为头结点
        ListNode pre = null;
        while (after != null) {
            ListNode next = after.next; //保存 after 的 next , 以防取下 head 后丢失
            after.next = pre; //将after的下一个节点反转，连接上一个节点
            pre = after;// pre 右移
            after = next;// after 右移
        }

        // 合并两个有序链表
        ListNode first = head;
        after = pre;
        while (first != null && after != null) {
            ListNode firstNext = first.next;
            ListNode afterNext = after.next;

            first.next = after;
            first = firstNext;

            after.next = first;
            after = afterNext;
        }

    }
}
