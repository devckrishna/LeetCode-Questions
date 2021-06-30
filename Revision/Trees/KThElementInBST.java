import java.util.ArrayList;

public class KThElementInBST {
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

  int ans = 0;

  public int kthSmallest(TreeNode root, int k) {
    ArrayList<Integer> arr = new ArrayList<>();
    solve(root, k, arr);
    if (arr.size() < k) {
      int curr = k - arr.size();
      arr = new ArrayList<>();
      solve(root.right, k, arr);
    }
    return ans;
  }

  public void solve(TreeNode root, int k, ArrayList<Integer> arr) {
    if (root == null) {
      return;
    }
    solve(root.left, k, arr);
    arr.add(root.val);
    if (arr.size() == k) {
      ans = arr.get(arr.size() - 1);
    }
    solve(root.right, k, arr);
  }
}