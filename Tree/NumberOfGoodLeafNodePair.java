import java.util.*;

public class NumberOfGoodLeafNodePair {
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

  int ans = 0;

  public int countPairs(TreeNode root, int distance) {
    solve(root, distance);
    return ans;
  }

  public List<Integer> solve(TreeNode root, int distance) {
    List<Integer> curr = new ArrayList<>();
    if (root == null) {
      return curr;
    }
    List<Integer> left = solve(root.left, distance);
    List<Integer> right = solve(root.right, distance);

    if (left.isEmpty() && right.isEmpty()) {
      curr.add(1);
      return curr;
    }

    if (!left.isEmpty() && !right.isEmpty()) {
      for (int l : left) {
        for (int r : right) {
          if (l + r <= distance) {
            ans++;
          }
        }
      }
    }

    for (int l : left) {
      curr.add(l + 1);
    }

    for (int r : right) {
      curr.add(r + 1);
    }
    return curr;
  }
}
