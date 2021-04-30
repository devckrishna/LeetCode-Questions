public class FindNodeInCloneTree {
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

  static TreeNode ans;

  public static void solve(TreeNode root, TreeNode target) {
    if (root == null) {
      return;
    }
    if (root.val == target.val) {
      ans = root;
      return;
    }
    solve(root.left, target);
    solve(root.right, target);
  }

  public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
    ans = null;
    solve(cloned, target);
    return ans;
  }
}
