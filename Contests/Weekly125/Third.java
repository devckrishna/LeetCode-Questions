import java.util.*;

public class Third {
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

  public void preorder(TreeNode root, List<Integer> pre) {
    if (root == null) {
      return;
    }
    preorder(root.left, pre);
    pre.add(root.val);
    preorder(root.right, pre);
  }

  public TreeNode solve(List<Integer> pre, int start, int end) {
    if (start >= end) {
      return null;
    }
    int mid = start;
    int max = pre.get(mid);
    for (int i = start; i < end; i++) {
      if (pre.get(i) >= max) {
        max = pre.get(i);
        mid = i;
      }
    }
    TreeNode ans = new TreeNode(pre.get(mid));
    ans.left = solve(pre, start, mid);
    ans.right = solve(pre, mid + 1, end);
    return ans;
  }

  public TreeNode insertIntoMaxTree(TreeNode root, int val) {
    List<Integer> pre = new ArrayList<>();
    preorder(root, pre);
    pre.add(val);
    return solve(pre, 0, pre.size());
  }
}