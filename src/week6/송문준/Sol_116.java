package week6.송문준;

import java.util.LinkedList;
import java.util.Queue;

public class Sol_116 {

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Node nextDepthRoot; // 다음 Depth 시작지점

        if (root == null)
            return root;

        queue.offer(root);
        nextDepthRoot = root.left;

        while (!queue.isEmpty()) {
            Node myRoot = queue.poll();

            if (myRoot == nextDepthRoot) { // Depth 시작지점과 같으면 if문 실행
                nextDepthRoot = myRoot.left;
            }

            if (myRoot.left != null) { // 완벽 이진 트리라 left만 체크
                queue.offer(myRoot.left);
                queue.offer(myRoot.right);
            }
            if (nextDepthRoot != queue.peek()) { // 맨 우측이 아닐경우 if문 실행
                myRoot.next = queue.peek();
            }
        }

        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
