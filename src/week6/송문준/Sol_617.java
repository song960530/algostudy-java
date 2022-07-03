package week6.송문준;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 못풀었음
public class Sol_617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        Queue<Integer> queue1_1 = new LinkedList<>();
        Queue<Integer> queue2_2 = new LinkedList<>();

        queue1.offer(root1);
        queue2.offer(root2);

        bfsSet(queue1, queue1_1);
        bfsSet(queue2, queue2_2);

        return makeBinaryTree(queue1_1, queue2_2);
    }

    private TreeNode makeBinaryTree(Queue<Integer> queue1_1, Queue<Integer> queue2_2) {
        int size = queue1_1.size() > queue2_2.size() ? queue1_1.size() : queue2_2.size();
        Integer q1;
        Integer q2;
        int sum;
        List<TreeNode> nodes = new ArrayList<>();
        TreeNode result = null;

        for (int i = 0; i < size; i++) {
            q1 = null;
            q2 = null;
            sum = 0;

            if (!queue1_1.isEmpty()) {
                q1 = queue1_1.poll();
            }

            if (!queue2_2.isEmpty()) {
                q2 = queue2_2.poll();
            }

            TreeNode mergeNode = null;

            if (q1 != null || q2 != null) {
                sum = (q1 == null ? 0 : q1) + (q2 == null ? 0 : q2);
                mergeNode = new TreeNode(sum);
            }
            nodes.add(mergeNode);
        }

        for (int i = 0; i < nodes.size(); i++) {
            if (i == 0) {
                result = nodes.get(i);
                continue;
            }

            if (i % 2 == 1) { // left
                nodes.get(i / 2).left = nodes.get(i);
            } else { // right
                nodes.get((i / 2) - 1).right = nodes.get(i);
            }
        }

        return result;
    }

    private void bfsSet(Queue<TreeNode> rootQueue, Queue<Integer> saveQueue) {
        while (!rootQueue.isEmpty()) {
            TreeNode node = rootQueue.poll();
            saveQueue.offer(node == null ? null : node.val);

            if (node == null)
                continue;


            rootQueue.offer(node.left);
            rootQueue.offer(node.right);
        }

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
