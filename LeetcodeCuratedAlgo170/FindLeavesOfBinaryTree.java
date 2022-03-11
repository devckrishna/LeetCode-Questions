import java.util.*;

public class FindLeavesOfBinaryTree {
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

  public TreeNode solve(TreeNode root, List<Integer> curr) {
    if (root == null) {
      return null;
    }

    TreeNode left = solve(root.left, curr);
    TreeNode right = solve(root.right, curr);
    if (root.left == null && root.right == null) {
      curr.add(root.val);
      return null;
    }
    root.left = left;
    root.right = right;
    return root;
  }

  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    while (root != null) {
      List<Integer> curr = new ArrayList<>();
      root = solve(root, curr);
      ans.add(curr);
    }

    return ans;
  }
}