package com.company.hot100;

import com.company.base.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * @author: Mask
 * @time: 2020/11/19 5:34 下午
 */
public class A94_InorderTraversal {

//    public List<Integer> inorderTraversal2(TreeNode root) {
//        List<Integer> out = new LinkedList<>();
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        while (root != null) {
//            stack.addLast(root);
//            if(root.left == null)
//        }
//        return out;
//    }

    //    递归 dfs
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> out = new LinkedList<>();
        if (root == null) {
            return out;
        }
        dfs(out, root);
        return out;
    }

    private void dfs(List<Integer> out, TreeNode root) {
        if (root.left != null) {
            dfs(out, root.left);
        }
        out.add(root.val);
        if (root.right != null) {
            dfs(out, root.right);
        }
    }
}
