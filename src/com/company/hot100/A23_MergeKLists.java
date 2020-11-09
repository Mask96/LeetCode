package com.company.hot100;

import com.company.base.ListNode;

/**
 * @description: 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 * @author: Mask
 * @time: 2020/11/9 7:53 下午
 */
public class A23_MergeKLists {

    //    二分两两合并
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return mergeTowList(lists[0], lists[1]);
        }

        int mid = lists.length / 2;
        ListNode[] list1 = new ListNode[mid];
        for (int i = 0; i < mid; i++) {
            list1[i] = lists[i];
        }

        ListNode[] list2 = new ListNode[lists.length - mid];
        for (int i = mid; i < lists.length; i++) {
            list2[i-mid] = lists[i];
        }

        return mergeTowList(mergeKLists2(list1),mergeKLists2(list2));
    }


    //    顺序两两合并
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode res = lists[0];
        for (int i = 1; i < lists.length; i++) {
            res = mergeTowList(res, lists[i]);
        }

        return res;
    }

    private ListNode mergeTowList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTowList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTowList(l1, l2.next);
            return l2;
        }
    }
}
