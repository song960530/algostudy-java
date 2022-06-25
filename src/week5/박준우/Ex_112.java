package leetcode;

import Programmers.Ex_42579;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Ex_112 {

    public static boolean flag;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        flag = false;
        if(root == null) return false;

        recursive(root, new ArrayList<>(), targetSum);

        return flag;
    }


    public static void recursive(TreeNode node, List<Integer> list, int targetSum) {
        if(node.left == null && node.right == null) {
            list.add(node.val);
            //System.out.println(list.stream().mapToInt(a->a).sum());
            //System.out.println(targetSum == list.stream().mapToInt(a->a).sum());
            if(targetSum == list.stream().mapToInt(a->a).sum()) {
                flag = true;
            }
        } else {
            list.add(node.val);
            if(node.left != null) {
                List<Integer> newList = new ArrayList<>();
                newList.addAll(list);
                //newList.add(node.left.val);
                recursive(node.left, newList, targetSum);
            }
            if(node.right != null) {
                List<Integer> newList = new ArrayList<>();
                newList.addAll(list);
                //newList.add(node.right.val);
                recursive(node.right, newList, targetSum);
            }
        }
    }
}