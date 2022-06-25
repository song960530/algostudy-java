package leetcode;
import java.util.*;
public class Ex_113 {


    public static List<List<Integer>> lists;
    public static int finalSum;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        lists = new ArrayList<>();
        finalSum = targetSum;


        if(root == null) return lists;

        recursive(root, new ArrayList<>());


        return lists;
    }

    public static void recursive(TreeNode node, List<Integer> list) {
        if(node.left == null && node.right == null) {
            list.add(node.val);
            if(finalSum == list.stream().mapToInt(a->a).sum()) {
                lists.add(list);
            }
        } else {
            list.add(node.val);
            if(node.left != null) {
                List<Integer> newList = new ArrayList<>();
                newList.addAll(list);
                recursive(node.left, newList);
            }
            if(node.right != null) {
                List<Integer> newList = new ArrayList<>();
                newList.addAll(list);
                recursive(node.right, newList);
            }
        }
    }



}
