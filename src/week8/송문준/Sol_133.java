package week8.송문준;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sol_133 {
    Map<Integer, Node> nodeMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (nodeMap.containsKey(node.val)) {
            return nodeMap.get(node.val);
        }
        Node root = new Node(node.val);
        nodeMap.put(node.val, root);
        for (Node neighbor : node.neighbors) {
            root.neighbors.add(cloneGraph(neighbor));
        }
        return root;
    }

    static class Node {
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
}
