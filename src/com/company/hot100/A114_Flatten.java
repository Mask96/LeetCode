package com.company.hot100;

import com.company.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给定一个二叉树，原地将它展开为一个单链表。
 * <p>
 *  
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * @author: Mask
 * @time: 2020/12/7 7:37 下午
 */
public class A114_Flatten {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        dfs(root, list);
        for (int i = 0; i < list.size()-1; i++) {
            root = list.get(i);
            root.left = null;
            root.right = list.get(i+1);
        }
    }

    private void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }

        list.add(root);

        dfs(root.left, list);
        dfs(root.right, list);
    }
}
