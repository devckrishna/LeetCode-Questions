public class BSToGreaterTree {
  int sum;

  public TreeNode bstToGst(TreeNode root) {
    TreeNode ans = root;
    sum = 0;
    solve(root);
    return ans;
  }

  public void solve(TreeNode root) {
    if (root == null) {
      return;
    }
    solve(root.right);
    sum += root.val;
    root.val = sum;
    solve(root.left);
  }

}
