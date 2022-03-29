public class Second {
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
  TreeNode curr = null;

  public TreeNode increasingBST(TreeNode root) {
    solve(root);
    return curr;
  }

  public void solve(TreeNode root) {
    if (root == null) {
      return;
    }
    solve(root.left);
    if (ans == null) {
      ans = new TreeNode(root.val);
      curr = ans;
    } else {
      ans.right = new TreeNode(root.val);
      ans = ans.right;
    }
    solve(root.right);
  }
}
