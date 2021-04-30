public class DeepestLeavesSum {
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

  static int sum;

  public int findDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = findDepth(root.left);
    int right = findDepth(root.right);
    return Math.max(left, right) + 1;
  }

  public void solve(TreeNode root, int depth) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null && depth == 0) {
      sum += root.val;
    }
    solve(root.left, depth - 1);
    solve(root.right, depth - 1);
  }

  public int deepestLeavesSum(TreeNode root) {
    int depth = findDepth(root);
    System.out.println(depth);
    sum = 0;
    solve(root, depth);
    return sum;
  }
}
