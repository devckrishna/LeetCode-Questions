public class ConstructBiniaryTreeFromPreOrderTRaversl {
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

  int index = 0;

  public TreeNode bstFromPreorder(int[] preorder) {
    return solve(preorder, Integer.MAX_VALUE);
  }

  public TreeNode solve(int[] pre, int max) {
    if (index == pre.length || pre[index] > max) {
      return null;
    }
    TreeNode root = new TreeNode(pre[index++]);
    root.left = solve(pre, root.val);
    root.right = solve(pre, max);
    return root;
  }
}
