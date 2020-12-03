package com.company.hot100;

import com.company.base.TreeNode;

/**
 * @description: 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * @author: Mask
 * @time: 2020/12/2 7:38 下午
 */
public class A104_MaxDepth {
    private int maxDeep = 0;

    public int maxDepth(TreeNode root) {
        int deep = 0;
        dfs(root, deep);
        return maxDeep;
    }

    private void dfs(TreeNode root, int deep) {
        if (root == null) {
            maxDeep = Math.max(maxDeep, deep);
            return;
        }

        dfs(root.left, deep + 1);
        dfs(root.right, deep + 1);
    }
}
