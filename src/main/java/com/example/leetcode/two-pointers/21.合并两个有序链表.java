/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 * 双指针
 */

// @lc code=start

import com.example.leetcode.base.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preNode = new ListNode(-1);
        ListNode temp = preNode;
        ListNode p1 = list1,p2= list2;
        while(p1!=null && p2!=null){
            if(p1.val<=p2.val){
                temp.next = p1;
                p1 = p1.next;
            }else{
                temp.next = p2;
                p2 = p2.next;
            }
            temp = temp.next;
        }
        if(p1!=null){
            temp.next = p1;
        }
        if(p2!=null){
            temp.next = p2;
        }
        return preNode.next;
    }
}
// @lc code=end

