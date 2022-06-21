package week5.이근형;

public class Leet98 {

    static boolean isValidBST(TreeNode root) {
        if(root == null) return false;
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean check(TreeNode curn, long min, long max) {
        if(curn == null) return true;
        if(curn.val >= max || curn.val <= min) return false;
        return check(curn.left, min, curn.val) && check(curn.right, curn.val, max);
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
