package com.company.hot100;

import com.company.base.TreeNode;

import java.util.*;

/**
 * @description: 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 *  
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * @author: Mask
 * @time: 2020/12/3 5:27 下午
 */
public class A102_LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        if (root == null) {
            return result;
        }

        stack.addLast(root);

        while (stack.size() > 0) {
            List<Integer> curResult = new ArrayList<>();
            int len = stack.size();

            for (int i = 0; i < len; i++) {
                TreeNode node = stack.removeFirst();
                curResult.add(node.val);

                if (node.left != null) {
                    stack.addLast(node.left);
                }
                if (node.right != null) {
                    stack.addLast(node.right);
                }
            }
            result.add(curResult);
        }

        return result;
    }
}
