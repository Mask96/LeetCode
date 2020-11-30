package com.company.hot100;

import com.company.base.ListNode;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @description: 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <p>
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * @author: Mask
 * @time: 2020/11/30 7:10 下午
 */
public class A148_SortList {
    /**
     * 通过递归实现链表归并排序，有以下两个环节：
     * 分割 cut 环节： 找到当前链表中点，并从中点将链表断开（以便在下次递归 cut 时，链表片段拥有正确边界）；
     * 我们使用 fast,slow 快慢双指针法，奇数个节点找到中点，偶数个节点找到中心左边的节点。
     * 找到中点 slow 后，执行 slow.next = None 将链表切断。
     * 递归分割时，输入当前链表左端点 head 和中心节点 slow 的下一个节点 tmp(因为链表是从 slow 切断的)。
     * cut 递归终止条件： 当head.next == None时，说明只有一个节点了，直接返回此节点。
     * 合并 merge 环节： 将两个排序链表合并，转化为一个排序链表。
     * 双指针法合并，建立辅助ListNode h 作为头部。
     * 设置两指针 left, right 分别指向两链表头部，比较两指针处节点值大小，由小到大加入合并链表头部，指针交替前进，直至添加完两个链表。
     * 返回辅助ListNode h 作为头部的下个节点 h.next。
     * 时间复杂度 O(l + r)，l, r 分别代表两个链表长度。
     * 当题目输入的 head == None 时，直接返回None。
     */
    public ListNode sortList(ListNode head) {
        //    1. 分割（快慢指针平分链表）
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(temp);

        // 2. 合并(两链表顺序合并)
        ListNode newNode = new ListNode(0);
        ListNode res = newNode;

        while (left != null && right != null) {
            if (left.val < right.val) {
                newNode.next = left;
                left = left.next;
            } else {
                newNode.next = right;
                right = right.next;
            }
            newNode = newNode.next;
        }
        newNode.next = left == null ? right : left;

        return res.next;
    }

}
