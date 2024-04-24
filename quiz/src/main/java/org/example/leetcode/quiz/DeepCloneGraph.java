package org.example.leetcode.quiz;

import org.example.model.node.Node;

import java.util.*;

/**
 * @Author: DiDi
 * @Description:    深拷贝图
 *                  认为主要考验的就是遍历图
 * @Data: 2024-04-01-16:08
 */
public class DeepCloneGraph {

    public Node cloneGraph(Node node) {
        if (null == node) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        Map<Node, Node> nodeMap = new HashMap<>();
        nodeMap.put(node, new Node(node.val));
        while(!queue.isEmpty()) {
            Node topNode = queue.poll();
            for (Node neighbor : topNode.neighbors) {
                if (!nodeMap.containsKey(neighbor)) {
                    nodeMap.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }
                nodeMap.get(topNode).neighbors.add(nodeMap.get(neighbor));
            }
        }
        return nodeMap.get(node);
    }

    public static void main(String[] args) {
        System.out.println("...");
    }
}
