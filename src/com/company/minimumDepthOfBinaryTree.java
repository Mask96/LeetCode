package com.company;

import java.util.LinkedList;

public class minimumDepthOfBinaryTree {

    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<TreeNode> layerList = new LinkedList<TreeNode>();

        int start = 0;
        int end = 1;
        int level = 1;

        queue.addFirst(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.removeLast();

            //向后移动
            start++;

            //如果找到为叶子节点，则该值就是最小层数
            if (temp.left == null && temp.right == null) {
                return level;
            }

            if (temp.left != null) {
                queue.addFirst(temp.left);
            }
            if (temp.right != null) {
                queue.addFirst(temp.right);
            }

            // 遍历完一层
            if (start == end) {
                level++;
                start = 0;
                end = queue.size();
            }

        }

        return level;

    }
}
