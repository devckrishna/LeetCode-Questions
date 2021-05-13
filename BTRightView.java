import java.util.*;

public class BTRightView {
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

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    solve(root, ans, 0);
    return ans;
  }

  public void solve(TreeNode root, List<Integer> ans, int depth) {
    if (root == null) {
      return;
    }
    if (depth == ans.size()) {
      ans.add(root.val);
    }
    solve(root.right, ans, depth + 1);
    solve(root.left, ans, depth + 1);
  }
}
