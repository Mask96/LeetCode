package com.company;

import java.util.*;

/**
 * @description: 本题要求复制一个无向图，图中每个节点都包含一个标签和它的邻居列表
 * 我们无向图用以下的方法序列化：
 * 节点的标签是互不相同的，
 * 我们使用“#”作为节点之间的分隔符，使用“,”作为节点标签和节点的节点邻居的分隔符。
 * 例如：现在有一个序列化的无向图{0,1,2#1,2#2,2}.
 * 这个无向图一共有3个节点，因此序列被#分隔成三部分
 * 第一个节点的标签是0，节点0和节点1，节点2之间有边
 * 第二个节点的标签是1，节点1和节点2之间有边
 * 第三个节点的标签是2，节点2和节点2（它自己）之间有边，形成了自环
 * @author: Mask
 * @time: 2020/6/4 5:48 下午
 */
class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};

public class CloneGraph133 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> nodeMap = new HashMap<>();
        Queue<UndirectedGraphNode> nodeQueue = new LinkedList<>();
        Set<Integer> nodeSet = new HashSet<>();

        if(node == null){
            return node;
        }

        // 第一次宽度遍历。将所有点存在map中。
        nodeQueue.offer(node);
        while (!nodeQueue.isEmpty()) {
            // 如果队列里不为空，将第一个取出，将其邻居节点加入队列。取出点加入到map和set
            UndirectedGraphNode curNode = nodeQueue.poll();

            if (!nodeSet.contains(curNode.label)) {
                //第一次加入该节点，set中没有
                for (UndirectedGraphNode neiNode : curNode.neighbors) {
                    nodeQueue.offer(neiNode);
                }
                UndirectedGraphNode newNode = new UndirectedGraphNode(curNode.label);
                nodeMap.put(curNode.label, newNode);
                nodeSet.add(curNode.label);
            }
        }

        nodeSet.clear();
        nodeQueue.clear();
        // 第二次宽度遍历，加入邻居节点
        nodeQueue.offer(node);
        while (!nodeQueue.isEmpty()) {
            UndirectedGraphNode curNode = nodeQueue.poll();

            if (!nodeSet.contains(curNode.label)) {
                ArrayList<UndirectedGraphNode> neiNodeList = new ArrayList<>();
                for (UndirectedGraphNode neiNode : curNode.neighbors) {
                    neiNodeList.add(nodeMap.get(neiNode.label));
                    nodeQueue.offer(neiNode);
                }
                nodeMap.get(curNode.label).neighbors = neiNodeList;
                nodeSet.add(curNode.label);
            }

        }

        return nodeMap.get(node.label);
    }
}
