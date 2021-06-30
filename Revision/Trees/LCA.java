public class LCA {
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

  TreeNode ans = null;

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    solve(root, p, q);
    return ans;
  }

  public boolean solve(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return false;
    }
    int left = solve(root.left, p, q) ? 1 : 0;
    int right = solve(root.right, p, q) ? 1 : 0;
    int mid = (root == p || root == q) ? 1 : 0;
    if (left + right + mid >= 2) {
      ans = root;
    }
    return left + right + mid > 0;
  }
}
