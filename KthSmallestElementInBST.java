import java.util.*;

class KthSmallestElementInBST {
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

  public int kthSmallest(TreeNode root, int k) {
    List<Integer> ans = new ArrayList<Integer>();
    solve(root, ans);
    return ans.get(k - 1);
  }

  public static void solve(TreeNode root, List<Integer> ans) {
    if (root == null) {
      return;
    }
    solve(root.left, ans);
    ans.add(root.val);
    solve(root.right, ans);

  }
}