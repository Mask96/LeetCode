package com.company.hot100;

import com.company.base.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @author: Mask
 * @time: 2020/12/2 5:26 下午
 */
public class A98_IsValidBST {

    private long pre = Long.MIN_VALUE;

    // 利用中序遍历
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (root.val <= pre) {
            return false;
        }
        pre = root.val;

        return isValidBST(root.right);

    }
}
