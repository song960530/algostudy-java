package week5.이근형;

import java.util.LinkedList;
import java.util.Queue;

public class Leet104 {

    public int maxDepth(TreeNode root) { // DFS 방식
        if(root == null) return 0;
        return dfs(root, 0);
    }

    public int dfs(TreeNode curn, int depth) {
        if(curn == null) return depth;
        depth++;
        return Math.max(dfs(curn.left, depth), dfs(curn.right, depth));
    }

//    static int maxDepth(TreeNode root) { // BFS 방식
//
//        if (root == null) return 0;
//
//        Queue<TreeNode> que = new LinkedList<>();
//        que.offer(root);
//        int depth = 0;
//
//        while (!que.isEmpty()) {
//            depth++;
//            int size = que.size();
//
//            for (int i = 0; i < size; i++) {
//                TreeNode curn = que.poll();
//
//                if (curn.left != null) {
//                    que.offer(curn.left);
//                }
//
//                if (curn.right != null) {
//                    que.offer(curn.right);
//                }
//            }
//        }
//        return depth;
//    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
