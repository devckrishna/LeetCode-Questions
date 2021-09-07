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

  List<Integer> arr = new ArrayList<>();

  public TreeNode balanceBST(TreeNode root) {
    inorder(root);
    return solve(0, arr.size() - 1);
  }

  public void inorder(TreeNode root) {
    if (root == null) {
      return;
    }
    inorder(root.left);
    arr.add(root.val);
    inorder(root.right);
  }

  public TreeNode solve(int left, int right) {
    if (left > right) {
      return null;
    }
    int mid = (left + right) / 2;
    TreeNode ans = new TreeNode(arr.get(mid));
    ans.left = solve(left, mid - 1);
    ans.right = solve(mid + 1, right);
    return ans;
  }
}
