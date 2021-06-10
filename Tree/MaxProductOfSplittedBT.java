public class MaxProductOfSplittedBT {
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

  static int mod;
  static int sum;
  static long ans;

  public void calcSum(TreeNode root) {
    if (root == null) {
      return;
    }
    sum += root.val;
    calcSum(root.left);
    calcSum(root.right);
  }

  public int solve(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = solve(root.left);
    int right = solve(root.right);
    int currSum = left + right + root.val;
    ans = Math.max(ans, (sum - currSum) * currSum);
    return currSum % mod;
  }

  public int maxProduct(TreeNode root) {
    mod = 1000000007;
    sum = 0;
    ans = 0;
    calcSum(root);
    solve(root);
    return (int) ans % mod;
  }
}
