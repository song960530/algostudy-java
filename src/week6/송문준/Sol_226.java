package week6.송문준;

import java.util.LinkedList;
import java.util.Queue;

public class Sol_226 {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode tmp, myRoot;

        if (root == null) {
            return root;
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            myRoot = queue.poll();
            
            // 좌우 변경
            tmp = myRoot.left;
            myRoot.left = myRoot.right;
            myRoot.right = tmp;

            // 이진트리라 좌우 따로 체크
            if (myRoot.left != null) {
                queue.offer(myRoot.left);
            }
            if (myRoot.right != null) {
                queue.offer(myRoot.right);
            }
        }

        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
