public class GoodNodes {
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

  public int goodNodes(TreeNode root) {
    return solve(root, Integer.MIN_VALUE);
  }

  public int solve(TreeNode root, int min) {
    if (root == null) {
      return 0;
    }
    int ans = root.val >= min ? 1 : 0;
    ans += solve(root.left, Math.max(min, root.val));
    ans += solve(root.right, Math.max(min, root.val));
    return ans;
  }
}