package week5.이근형;

public class Leet112 {
    static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        if(targetSum - root.val == 0 && root.left == null && root.right == null) {
            return true;
        }

        return (hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val));
    }

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
