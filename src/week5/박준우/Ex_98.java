package leetcode;

public class Ex_98 {

    public boolean isValidBST(TreeNode root) {
        return CheckValidity(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public static boolean CheckValidity(TreeNode root,long leftMax,long rightMin) {
        if(root==null) return true;
        if(root.val<=leftMax ||root.val>=rightMin ) return false;

        return CheckValidity(root.left,leftMax,root.val) && CheckValidity(root.right,root.val,rightMin);
    }
}

/*
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return false;

        // flag: true (left)  / flag: false (right)
        return leftRecur(root.left, root.val, root.val, true) && rightRecur(root.right, root.val, root.val, false);
    }

    public static boolean leftRecur(TreeNode node, int upperVal, int rootVal, boolean flag) {
        if(node==null) return true;

        if(flag) { // left side subtree
            if(node.left == null && node.right == null) {
                return node.val < upperVal && node.val < rootVal;
            }
                return node.val < rootVal && node.val < upperVal && leftRecur(node.left, node.val, rootVal, flag) && rightRecur(node.right, node.val, rootVal, flag);
            } else { // right side subtree
            if(node.left == null && node.right == null) {
                System.out.println(node.val);
                System.out.println(node.val < rootVal);
                return node.val < upperVal && node.val > rootVal;
            }
                return node.val < rootVal && node.val < upperVal && leftRecur(node.left, node.val, rootVal, flag) && rightRecur(node.right, node.val, rootVal, flag);
        }


    }

    public static boolean rightRecur(TreeNode node, int upperVal, int rootVal, boolean flag) {
        if(node==null) return true;

        if(flag) { // left side subtree
            if(node.left == null && node.right == null) {
            return node.val > upperVal && node.val < rootVal;
        }

            return node.val < rootVal && node.val > upperVal && leftRecur(node.left, node.val,rootVal,flag) && rightRecur(node.right, node.val,rootVal,flag);
        } else { // right side subtree
            if(node.left == null && node.right == null) {
            return node.val > upperVal && node.val > rootVal;
        }

            return node.val > rootVal && node.val > upperVal && leftRecur(node.left, node.val,rootVal,flag) && rightRecur(node.right, node.val,rootVal,flag);
        }

    }
}
*/

