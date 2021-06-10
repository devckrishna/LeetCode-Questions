import java.util.*;

class HouseRobber3 {
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

  public static int[] solve(TreeNode root) {
    if (root == null) {
      return new int[] { 0, 0 };
    }
    int[] left = solve(root.left);
    int[] right = solve(root.right);
    int rob = root.val + left[1] + right[1];
    int noRov = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

    return new int[] { rob, noRov };
  }

  public int rob(TreeNode root) {
    int[] ans = solve(root);
    return Math.max(ans[0], ans[1]);
  }

  // Memoiztion approach------------------
  HashMap<TreeNode, Integer> robResult = new HashMap<>();
  HashMap<TreeNode, Integer> notRobResult = new HashMap<>();

  public int helper(TreeNode node, boolean parentRobbed) {
    if (node == null) {
      return 0;
    }
    if (parentRobbed) {
      if (robResult.containsKey(node)) {
        return robResult.get(node);
      }
      int result = helper(node.left, false) + helper(node.right, false);
      robResult.put(node, result);
      return result;
    } else {
      if (notRobResult.containsKey(node)) {
        return notRobResult.get(node);
      }
      int rob = node.val + helper(node.left, true) + helper(node.right, true);
      int notRob = helper(node.left, false) + helper(node.right, false);
      int result = Math.max(rob, notRob);
      notRobResult.put(node, result);
      return result;
    }
  }

  public int rob2(TreeNode root) {
    return helper(root, false);
  }
}