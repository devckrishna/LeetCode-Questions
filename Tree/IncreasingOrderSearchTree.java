public class IncreasingOrderSearchTree {
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

  TreeNode cur;

  public TreeNode increasingBST(TreeNode root) {
    TreeNode ans = new TreeNode(0);
    cur = ans;
    inorder(root);
    return ans.right;
  }

  public void inorder(TreeNode node) {
    if (node == null)
      return;
    inorder(node.left);
    node.left = null;
    cur.right = node;
    cur = node;
    inorder(node.right);
  }
}