package com.company;

import com.company.base.ListNode;

/**
 * @Classname InsertionSortList
 * @Description 使用插入排序对链表进行排序。
 * Sort a linked list using insertion sort.
 * 思路:新建一个链表,遍历原链表，将每个节点加入新链表正确的位置
 * @Date 2020/4/28 20:33
 * @Created by Mask
 */


public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            //保存当前节点下一个节点
            ListNode next = cur.next;
            pre = dummy;

            //寻找当前节点正确位置的一个节点
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }

            //pre < cur < pre.next
            //此时要把当前需要插入的节点(cur)插入到pre后(将当前节点加入新链表中)
            cur.next = pre.next;
            pre.next = cur;
            //处理下一个节点
            cur = next;
        }
        return dummy.next;
    }

}

