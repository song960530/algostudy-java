package week8.박준우;
/*
    Leetcode 그래프
    133 Clone Graph
 */

import java.util.*;

public class Ex_133 {

    /*
// Definition for a Node.
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
*/

    static boolean[] visited;
    public Node cloneGraph(Node node) {
        Node newNode = new Node();
        visited = new boolean[100+1];

        cloneNode(newNode, node, node.neighbors);

        return newNode;
    }


    public static void cloneNode(Node newNode, Node node, List<Node> near) {
        newNode.neighbors = new ArrayList<Node>();

        if(!near.isEmpty()) {
            for(Node n : near) {
                if(!visited[n.val]) {
                    Node created = new Node(n.val);
                    newNode.neighbors.add(created);
                    visited[n.val] = true;
                    cloneNode(created, n, n.neighbors);
                }
            }
        }
    }
}
