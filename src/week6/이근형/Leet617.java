package week6.이근형;

import java.util.LinkedList;
import java.util.Queue;

public class Leet617 {

    // BFS
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;

        TreeNode result = new TreeNode(root1.val + root2.val);
        Queue<TreeNode> que = new LinkedList<>();
        Queue<TreeNode> que1 = new LinkedList<>();
        Queue<TreeNode> que2 = new LinkedList<>();

        que.offer(result);
        que1.offer(root1);
        que2.offer(root2);

        while(!que1.isEmpty() && !que2.isEmpty()) {
            TreeNode node = que.poll();
            TreeNode node1 = que1.poll();
            TreeNode node2 = que2.poll();

            if(node1.left != null || node2.left != null) {
                if(node1.left != null && node2.left != null) {
                    TreeNode leftNode = new TreeNode(node1.left.val + node2.left.val);
                    node.left = leftNode;
                    que.offer(leftNode);
                    que1.offer(node1.left);
                    que2.offer(node2.left);
                }

                // 한쪽이 null 이면 존재하는 쪽을 가져오기 때문에 자식 노드는 자동으로 따라온다.
                // 그러므로 추가적으로 탐색할 필요가 없다.
                else if(node1.left != null && node2.left == null) {
                    node.left = node1.left;
                }

                else if(node1.left == null && node2.left != null) {
                    node.left = node2.left;
                }
            }

            if(node1.right != null || node2.right != null) {
                if(node1.right != null && node2.right != null) {
                    TreeNode rightNode = new TreeNode(node1.right.val + node2.right.val);
                    node.right = rightNode;
                    que.offer(rightNode);
                    que1.offer(node1.right);
                    que2.offer(node2.right);
                }

                // 한쪽이 null 이면 존재하는 쪽을 가져오기 때문에 자식 노드는 자동으로 따라온다.
                // 그러므로 추가적으로 탐색할 필요가 없다.
                else if(node1.right != null && node2.right == null) {
                    node.right = node1.right;
                }

                else if(node1.right == null && node2.right != null) {
                    node.right = node2.right;
                }
            }
        }
        return result;
    }
}
    // DFS + recursion
//    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//        if(root1 == null) return root2;
//        if(root2 == null) return root1;
//
//        root1.val += root2.val;
//
//        root1.left = mergeTrees(root1.left, root2.left);
//        root1.right = mergeTrees(root1.right, root2.right);
//
//        return root1;
//    }
