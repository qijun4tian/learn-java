package 深度搜索;

import java.util.*;

/**
 * @author:qijun
 * @Description
 * @Date 21:23 2022/1/19
 */
public class 克隆图 {

    class Node {
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

    private Map<Integer, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node.val)) {
            return visited.get(node.val);
        }
        Node node1 = new Node();
        node1.val = node.val;
        visited.put(node1.val, node1);
        node1.neighbors = new ArrayList<>();
        for (Node neighbor : node.neighbors) {
            node1.neighbors.add(cloneGraph(neighbor));
        }
        return node1;

    }

}
