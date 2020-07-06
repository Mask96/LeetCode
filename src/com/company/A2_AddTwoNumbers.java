package com.company;

/**
 * @description: 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @author: Mask
 * @time: 2020/7/6 5:12 下午
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class A2_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        A2_AddTwoNumbers addTwoNumbers = new A2_AddTwoNumbers();
        addTwoNumbers.addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode temp = new ListNode(0);
        ListNode cur = temp;
        boolean isUp = false;
        while (l1 != null || l2 != null) {
            int sum = isUp ? 1 : 0;
            if (l1 == null) {
                sum = sum + l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = sum + l1.val;
                l1 = l1.next;
            } else {
                sum = sum + l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }

            // 判断是否会进位
            if (sum > 9) {
                sum = sum % 10;
                isUp = true;
            } else {
                isUp = false;
            }

            cur.next = new ListNode(sum);
            cur = cur.next;

        }
        if(isUp){
            cur.next = new ListNode(1);
        }

        return temp.next;
    }
}
