package leetcode;

/*
    leetcode 617 Merge Two Binary Trees
 */

public class Ex_617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return null;

        if( root1 == null || root2 == null) {
            return root1 != null ? root1 : root2;
        }

        TreeNode result = new TreeNode(root1.val + root2.val);
        result.left = mergeTrees(root1.left, root2.left);
        result.right = mergeTrees(root1.right, root2.right);

        return result;
    }
}
