import java.util.*;

public class PrintBt {
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

  public List<List<String>> printTree(TreeNode root) {
    int rows = depth(root), cols = (int) Math.pow(2, rows) - 1;
    int mid = cols / 2;
    List<List<String>> res = new ArrayList<>();
    List<String> l = new ArrayList<>(Collections.nCopies(cols, ""));
    for (int i = 0; i < rows; i++) {
      res.add(new ArrayList<>(l));
    }
    pre(root, 0, mid, cols / 2, res);
    return res;
  }

  public void pre(TreeNode root, int row, int col, int half, List<List<String>> res) {
    if (root == null)
      return;
    res.get(row).set(col, "" + root.val);
    pre(root.left, row + 1, col - half / 2 - 1, half / 2, res);
    pre(root.right, row + 1, col + half / 2 + 1, half / 2, res);
  }

  public int depth(TreeNode root) {
    if (root == null)
      return 0;
    return 1 + Math.max(depth(root.left), depth(root.right));
  }
}
