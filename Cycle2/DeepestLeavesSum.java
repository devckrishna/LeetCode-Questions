public class DeepestLeavesSum {
  public class TreeNode {
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

  int ans = 0;
  int d = 0;

  public int deepestLeavesSum(TreeNode root) {
    d = depth(root);
    solve(root, 0);
    return ans;
  }

  public void solve(TreeNode root, int h) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null && h == d - 1) {
      ans += root.val;
    }
    solve(root.left, h + 1);
    solve(root.right, h + 1);
  }

  public int depth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = depth(root.left);
    int right = depth(root.right);
    return Math.max(left, right) + 1;
  }
}
