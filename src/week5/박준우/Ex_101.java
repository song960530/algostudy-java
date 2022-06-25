package leetcode;

public class Ex_101 {
    public boolean isSymmetric(TreeNode root) {

        if(root==null) return true;

        return recursive(root.left, root.right);

    }

    public static boolean recursive(TreeNode rootLeft, TreeNode rootRight) {

        if(rootLeft == null || rootRight == null) return rootLeft==rootRight;

        if(rootLeft.val != rootRight.val) return false;

        return recursive(rootLeft.left, rootRight.right) && recursive(rootLeft.right, rootRight.left);

    }

}
