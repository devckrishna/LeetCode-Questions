public class FlattenBinaryTreeToLinkedList {
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

  TreeNode prev = null;

  public void flatten(TreeNode root) {
    solve(root);
    root = prev;
  }

  public void solve(TreeNode root) {
    if (root == null) {
      return;
    }
    solve(root.right);
    solve(root.left);
    root.right = prev;
    root.left = null;
    prev = root;
  }
}
