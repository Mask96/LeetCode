package com.company;

/**
 * @description: 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * @author: Mask
 * @time: 2020/11/4 7:07 下午
 */
public class A19_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {

//        采用双节点方法，head节点和 head+n节点，当head+n节点到结尾时，删除head节点。
        ListNode delNode = head;
        ListNode temp = head;
        for (int i = 0; i < n; i++) {
            temp = temp.next;
        }

        while (temp != null && temp.next != null) {
            delNode = delNode.next;
            temp = temp.next;
        }
        if (temp == null) {
            // 不用移动，删除自身。
           return head.next;
        } else {
            delNode.next = delNode.next.next;
        }

        return head;
    }
}
