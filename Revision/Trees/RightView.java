import java.util.*;

public class RightView {
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

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    solve(root, 0, ans);
    return ans;
  }

  public void solve(TreeNode root, int depth, List<Integer> ans) {
    if (root == null) {
      return;
    }
    if (depth == ans.size()) {
      ans.add(root.val);
    }
    solve(root.right, depth + 1, ans);
    solve(root.left, depth + 1, ans);
  }

  // MAZA NI AAYA ISS SOLUTION ME----------------------
  // public List<Integer> rightSideView(TreeNode root) {
  // List<List<Integer>> ans = new ArrayList<>();
  // if (root == null) {
  // return ans.get(0);
  // }
  // Queue<TreeNode> qu = new LinkedList<>();
  // qu.add(null);
  // qu.add(root);

  // while (!qu.isEmpty()) {
  // TreeNode temp = qu.poll();
  // if (qu.size() == 0) {
  // break;
  // }
  // if (temp == null) {
  // List<Integer> curr = new ArrayList<>();
  // for (TreeNode n : qu) {
  // curr.add(n.val);
  // }
  // ans.add(curr);
  // qu.add(null);
  // } else {
  // if (temp.left != null) {
  // qu.add(temp.left);
  // }
  // if (temp.right != null) {
  // qu.add(temp.right);
  // }
  // }
  // }

  // List<Integer> res = new ArrayList<>();
  // for (List<Integer> curr : ans) {
  // res.add(curr.get(curr.size() - 1));
  // }
  // return res;
  // }
}
