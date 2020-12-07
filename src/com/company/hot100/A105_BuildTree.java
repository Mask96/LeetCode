package com.company.hot100;

import com.company.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * @author: Mask
 * @time: 2020/12/7 7:14 下午
 */
public class A105_BuildTree {
    private Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        for (int i = 0; i < len; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeExecutor(preorder, inorder, 0, len - 1, 0, len - 1);
    }

    public TreeNode buildTreeExecutor(int[] preorder, int[] inorder, int pre_left, int pre_right, int inorder_left, int inorder_right) {
        if (pre_left > pre_right) {
            return null;
        }

        // 前序的左边界就是根index
        int pre_root = pre_left;
        // 中序的根节点的位置
        int inorder_root = inorderMap.get(preorder[pre_root]);


        TreeNode root = new TreeNode(preorder[pre_root]);
        // 根节点左侧有节点数
        int size_left = inorder_root - inorder_left;

        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = buildTreeExecutor(preorder, inorder, pre_left + 1, pre_left + size_left, inorder_left, inorder_root - 1);

        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = buildTreeExecutor(preorder, inorder, pre_left + 1 + size_left, pre_right, inorder_root + 1, inorder_right);

        return root;
    }
}
