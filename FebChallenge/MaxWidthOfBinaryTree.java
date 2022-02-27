import java.util.*;

public class MaxWidthOfBinaryTree {
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

  int max = Integer.MIN_VALUE;

  public void dfs(TreeNode root, int index, ArrayList<Integer> res, int level) {
    if (root == null)
      return;
    if (level == res.size()) {
      res.add(index);
    }

    int curr = index - res.get(level) + 1;
    if (curr > max)
      max = curr;

    dfs(root.left, 2 * index, res, level + 1);
    dfs(root.right, 2 * index + 1, res, level + 1);
  }

  public int widthOfBinaryTree(TreeNode root) {
    dfs(root, 0, new ArrayList<Integer>(), 0);
    return max;
  }
}
