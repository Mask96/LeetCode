package com.company.hot100;

import com.company.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * @author: Mask
 * @time: 2020/12/8 5:10 下午
 */
public class A236_LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> rootMap = new HashMap<>();
        dfs(root, rootMap);

        // 构建p点的父节点list
        List<TreeNode> pRootList = new ArrayList<>();

        pRootList.add(p);
        while (rootMap.containsKey(p)) {
            pRootList.add(rootMap.get(p));
            p = rootMap.get(p);
        }

        // 找q点的父节点，当其在p的父节点list中有时，这个点就是最近父节点
        while (!pRootList.contains(q)) {
            q = rootMap.get(q);
        }

        return q;
    }

    // 构建一个key：当前节点 value：父节点的map
    public void dfs(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            map.put(root.left, root);
            dfs(root.left, map);
        }
        if (root.right != null) {
            map.put(root.right, root);
            dfs(root.right, map);
        }
    }
}
