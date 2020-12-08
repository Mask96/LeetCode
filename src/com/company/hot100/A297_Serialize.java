package com.company.hot100;

import com.company.base.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例: 
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * @author: Mask
 * @time: 2020/12/8 5:36 下午
 */
public class A297_Serialize {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TreeNode root, StringBuffer result) {
        if (root == null) {
            result.append("null,");
            return;
        } else {
            result.append(root.val).append(",");
            dfs(root.left, result);
            dfs(root.right, result);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return getTreeNode(data_list);
    }

    private TreeNode getTreeNode(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = getTreeNode(list);
        root.right = getTreeNode(list);

        return root;
    }
}
