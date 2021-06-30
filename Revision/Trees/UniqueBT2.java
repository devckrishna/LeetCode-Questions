import java.util.*;

public class UniqueBT2 {
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

  public List<TreeNode> generateTrees(int n) {
    return solve(1, n);
  }

  public List<TreeNode> solve(int start, int end) {
    List<TreeNode> ans = new ArrayList<>();
    if (start > end) {
      ans.add(null);
      return ans;
    }
    for (int i = start; i <= end; i++) {
      List<TreeNode> leftAns = solve(start, i - 1);
      List<TreeNode> rightAns = solve(i + 1, end);
      for (TreeNode left : leftAns) {
        for (TreeNode right : rightAns) {
          TreeNode root = new TreeNode(i);
          root.left = left;
          root.right = right;
          ans.add(root);
        }
      }
    }

    return ans;
  }
}
