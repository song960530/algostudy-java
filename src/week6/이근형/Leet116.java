package week6.이근형;

import java.util.LinkedList;
import java.util.Queue;

public class Leet116 {

    // BFS 방식
    public Node connect(Node root) {
        if(root == null) return root;

        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()) {
            int size = que.size();

            for(int i = 0; i < size; i++) {
                Node curn = que.poll();
                if(curn.left != null) {
                    que.offer(curn.left);
                }
                if(curn.right != null) {
                    que.offer(curn.right);
                }
                if(i != size - 1) {
                    curn.next = que.peek();
                }
            }
        }
        return root;
    }

    // DFS 방식
//    public Node connect(Node root) {
//
//        if(root == null) return root;
//        if(root.left != null) {
//            root.left.next = root.right;
//        }
//        if(root.right != null && root.next != null) {
//            root.right.next = root.next.left;
//        }
//
//        connect(root.left);
//        connect(root.right);
//
//        return root;
//    }
}
