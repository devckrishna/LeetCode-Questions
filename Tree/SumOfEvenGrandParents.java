public class SumOfEvenGrandParents {
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

  static int ans;

  public void solve(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.val % 2 == 0) {
      if (root.left != null) {
        if (root.left.left != null) {
          ans += root.left.left.val;
        }
        if (root.left.right != null) {
          ans += root.left.right.val;
        }
      }
      if (root.right != null) {
        if (root.right.left != null) {
          ans += root.right.left.val;
        }
        if (root.right.right != null) {
          ans += root.right.right.val;
        }
      }
    }
    solve(root.left);
    solve(root.right);

  }

  public int sumEvenGrandparent(TreeNode root) {
    ans = 0;
    solve(root);
    return ans;
  }
}
