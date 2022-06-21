package week5.이근형;

import java.util.ArrayList;
import java.util.List;

public class Leet113 {
    static List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        List<Integer> candidate = new ArrayList<>();
        check(root, targetSum, result, candidate);
        return result;
    }

    static void check(TreeNode curn, int targetSum, List<List<Integer>> result, List<Integer> candidate) {
        if(curn == null) return;
        candidate.add(curn.val);
        if(targetSum - curn.val == 0 && curn.left == null && curn.right == null) {
            result.add(new ArrayList<>(candidate));
        }
        else {
            check(curn.left, targetSum - curn.val, result, candidate);
            check(curn.right, targetSum - curn.val, result, candidate);
        }
        candidate.remove(candidate.size() - 1);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,  TreeNode left,  TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
