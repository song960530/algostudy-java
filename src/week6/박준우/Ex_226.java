package leetcode;
/*
    226. Invert Binary Tree
 */
public class Ex_226 {
    public TreeNode invertTree(TreeNode root) {
        recursive(root);
        return root;
    }

    public void recursive(TreeNode node) {
        if(node != null) {
            //if(node.left != null && node.right != null) {
            TreeNode temp = node.right;
            node.right = node.left == null ? null : node.left;
            node.left = temp == null ? null : temp;

            recursive(node.left);
            recursive(node.right);
            //}
        }

    }
}
