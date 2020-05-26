package com.company;

import java.util.HashMap;

/**
 * @description: 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的 深拷贝。 
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * @author: Mask
 * @time: 2020/5/25 5:23 下午
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Node, Node> nodeMap = new HashMap<>();

        Node node = head;

        // 将所有节点复制一份，存放到HashMap中，key是原节点，value是对应复制新节点，
        // 新节点只有val值，没有next和random指向关系
        while (node != null) {
            Node newNode = new Node(node.val);
            nodeMap.put(node, newNode);
            node = node.next;
        }

        node = head;
        while (node != null) {
            if (node.next != null) {
                nodeMap.get(node).next = nodeMap.get(node.next);
            } else {
                nodeMap.get(node).next = null;
            }
            if (node.random != null) {
                nodeMap.get(node).random = nodeMap.get(node.random);
            } else {
                nodeMap.get(node).random = null;
            }
            node = node.next;
        }

        return nodeMap.get(head);
    }
}
