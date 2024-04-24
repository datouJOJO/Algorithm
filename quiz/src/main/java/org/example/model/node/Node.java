package org.example.model.node;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DiDi
 * @Description: leetcode中的节点对象
 * @Data: 2024-04-01-16:06
 */
public class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
