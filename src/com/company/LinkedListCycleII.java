package com.company;

import com.company.base.ListNode;

/**
 * @description:对于一个给定的链表，返回环的入口节点，如果没有环，返回null 拓展：你能给出不利用额外空间的解法么？
 * @author: Mask
 * @time: 2020/5/8 5:10 下午
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        // 寻找快慢步相遇节点，如果meet节点为空则不相遇
        ListNode meet = findMeetListNode(head);

        if (meet == null) {
            return null;
        }

        //meet是快慢节点相遇的节点，根据推导公式，从head到入口点，和从相遇点到入口点会相遇
        while (head != meet) {
            head = head.next;
            meet = meet.next;
        }
        return head;
    }

    /**
     * @description:快慢指针，例如圆形跑道，两个人跑步，如果一个人跑的快，一个人跑的慢，那么不管两个人从哪个位置出发，跑的过程中两人一定会相遇。
     * @author: Mask
     * @time: 2020/5/8
     */
    private ListNode findMeetListNode(ListNode head) {
        ListNode meet = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                meet = slow;
                break;
            }
        }
        return meet;
    }

}
