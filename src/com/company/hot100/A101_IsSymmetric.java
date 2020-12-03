package com.company.hot100;

import com.company.base.TreeNode;

/**
 * @description: 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * @author: Mask
 * @time: 2020/12/2 7:14 下午
 */
public class A101_IsSymmetric {

    /**
     * 不能使用中序遍历然后求回文串
     * 因为中序遍历无法确认树的形状
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }

}
