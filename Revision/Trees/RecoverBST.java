public class RecoverBST {
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

  TreeNode first = null;
  TreeNode second = null;
  TreeNode prev = null;

  public void recoverTree(TreeNode root) {
    if (root == null) {
      return;
    }
    solve(root);
    if (first != null && second != null) {
      int temp = first.val;
      first.val = second.val;
      second.val = temp;
    }
  }

  public void solve(TreeNode root) {
    if (root == null) {
      return;
    }
    solve(root.left);
    if (prev != null && prev.val > root.val) {
      if (first == null) {
        first = prev;
      }
      if (first != null) {
        second = root;
      }
    }
    prev = root;
    solve(root.right);
  }
}
