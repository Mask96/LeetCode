package com.company;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @description:求给定的二叉树的后序遍历
 * @author: Mask
 * @time: 2020/4/29 3:58 下午
 */
public class BinaryTreePostorderTraversal {

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stackOut = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode outNode = stack.pop();
            stackOut.push(outNode);
            if (outNode.left != null) {
                stack.push(outNode.left);
            }
            if (outNode.right != null) {
                stack.push(outNode.right);
            }
        }

        while (!stackOut.empty()) {
            TreeNode treeNode = stackOut.pop();
            list.add(treeNode.val);
        }

        return list;
    }
}
