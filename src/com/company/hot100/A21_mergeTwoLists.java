package com.company.hot100;

import com.company.base.ListNode;

/**
 * @description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @author: Mask
 * @time: 2020/11/4 8:02 下午
 */
public class A21_mergeTwoLists {
    // 递归
    public ListNode mergeTwoListsBetter(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoListsBetter(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    //    迭代
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode pret = pre;

        while (l1 != null && l2 != null) {

            if (l1.val > l2.val) {
                pret.next = l2;
                l2 = l2.next;
            } else {
                pret.next = l1;
                l1 = l1.next;
            }
            pret = pret.next;
        }
        pret.next = l1 == null ? l2 : l1;
        return pre.next;
    }
}
