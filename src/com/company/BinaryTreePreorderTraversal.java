package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @description:求给定的二叉树的前序遍历
 * @author: Mask
 * @time: 2020/5/6 5:15 下午
 */
public class BinaryTreePreorderTraversal {

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queueOut = new LinkedList<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode outNode = stack.pop();
            queueOut.offer(outNode);
            // 入栈时先入右子树，出栈到队列时便为左子树先出，符合所需要求
            if (outNode.right != null) {
                stack.push(outNode.right);
            }
            if (outNode.left != null) {
                stack.push(outNode.left);
            }
        }

        while (!queueOut.isEmpty()) {
            list.add(queueOut.poll().val);
        }

        return list;
    }
}
