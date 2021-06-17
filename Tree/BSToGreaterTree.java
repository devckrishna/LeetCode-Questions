public class BSToGreaterTree {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  int sum;

  public TreeNode bstToGst(TreeNode root) {
    TreeNode ans = root;
    sum = 0;
    solve(root);
    return ans;
  }

  public void solve(TreeNode root) {
    if (root == null) {
      return;
    }
    solve(root.right);
    sum += root.val;
    root.val = sum;
    solve(root.left);
  }

}
