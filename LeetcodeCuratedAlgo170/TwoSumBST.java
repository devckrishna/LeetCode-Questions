import java.util.*;

public class TwoSumBST {
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

  public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
    Set<Integer> set = new HashSet<>();
    solve(root1, set);
    return findSum(root2, set, target);
  }

  public void solve(TreeNode root, Set<Integer> set) {
    if (root == null) {
      return;
    }
    set.add(root.val);
    solve(root.left, set);
    solve(root.right, set);
  }

  public boolean findSum(TreeNode root, Set<Integer> set, int target) {
    if (root == null) {
      return false;
    }
    if (set.contains(target - root.val)) {
      return true;
    }

    return findSum(root.left, set, target) || findSum(root.right, set, target);
  }
}
