package week5.박진향;

public class e_101 {

    public class TreeNode {
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

    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        // left right 노드가 모두 null이면 대칭
        // 둘 중 하나만 null일 경우는 비대칭
        if(left == null && right == null) return true;
        else if(left != null && right == null) return false;
        else if(left == null && right != null) return false;

        // left right 노드의 값이 다를 경우 비대칭
        // left -> left 노드와 right -> right 노드가 다를 경우 비대칭
        // left -> right 노드와 right -> left 노드가 다를 경우 비대칭
        // 이 외는 대칭
        if(left.val != right.val) return false;
        if(!isSymmetric(left.left, right.right)) return false;
        if(!isSymmetric(left.right, right.left)) return false;

        return true;
    }


}
