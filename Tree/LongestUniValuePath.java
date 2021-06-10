public class LongestUniValuePath {
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

  static int ans;

  public int solve(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = solve(root.left);
    int right = solve(root.right);
    int arrowLeft = 0;
    int arrowRight = 0;
    if (root.left != null && root.left.val == root.val) {
      arrowLeft += left + 1;
    }
    if (root.right != null && root.right.val == root.val) {
      arrowRight = right + 1;
    }
    ans = Math.max(ans, arrowLeft + arrowRight);
    return Math.max(arrowLeft, arrowRight);
  }

  public int longestUnivaluePath(TreeNode root) {
    ans = 0;
    solve(root);
    return ans;
  }
}
