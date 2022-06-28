package week6.이근형;

import java.util.LinkedList;
import java.util.Queue;

public class Leet226 {

    // BFS
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()) {
            TreeNode curn = que.poll();

            if(curn.left != null || curn.right != null) {
                TreeNode temp = curn.left;
                curn.left = curn.right;
                curn.right = temp;
            }
            if(curn.left != null) {
                que.offer(curn.left);
            }
            if(curn.right != null) {
                que.offer(curn.right);
            }
        }
        return root;
    }

    // DFS + recursion
//    public TreeNode invertTree(TreeNode root) {
//
//        if(root == null) return root;
//
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//
//        invertTree(root.left);
//        invertTree(root.right);
//
//        return root;
//    }
}
