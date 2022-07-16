package week8.이근형;

import java.util.*;

public class Leet133 {

    static Node cloneGraph(Node node) { // DFS
        if(node == null)
            return null;

        Map<Node, Node> visited = new HashMap<>();
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        dfs(node, visited);
        return cloneNode;
    }

    static void dfs(Node node, Map<Node, Node> visited) {
        Node cloneNode = visited.get(node);

        for(Node child : node.neighbors) {
            Node cloneChild = visited.getOrDefault(child, new Node(child.val));
            cloneNode.neighbors.add(cloneChild);

            if(!visited.containsKey(child)) {
                visited.put(child, cloneChild);
                dfs(child, visited);
            }
        }
    }

    // ************************************** BFS

    static Node cloneGraph2(Node node) {
        if(node == null) return null;

        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> que = new LinkedList<>();
        que.add(node);

        Node head = new Node(node.val);
        map.put(node, head);

        while(!que.isEmpty()){
            Node rem = que.poll();

            if(map.containsKey(rem) == false){
                Node newNode = new Node(rem.val);
                map.put(rem, newNode);
            }

            List<Node> ngbrs = rem.neighbors;
            Node n1 = map.get(rem);

            for(Node ngbr : ngbrs){
                if(map.containsKey(ngbr) == false){
                    Node n2 = new Node(ngbr.val);
                    map.put(ngbr, n2);
                    que.offer(ngbr);
                }
                Node n2 = map.get(ngbr);
                n1.neighbors.add(n2);
            }
        }
        return head;
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

