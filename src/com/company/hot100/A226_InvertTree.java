package com.company.hot100;

import com.company.base.TreeNode;

/**
 * @description: 二叉树左右交换
 * @author: Mask
 * @time: 2020/12/8 4:52 下午
 */
public class A226_InvertTree {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }

        dfs(root.left);
        dfs(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
