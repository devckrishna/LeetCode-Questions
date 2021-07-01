import java.util.*;

public class BinaryTreeCameras {
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
  Set<TreeNode> set;

  public int minCameraCover(TreeNode root) {
    set = new HashSet<>();
    set.add(null);
    dfs(root, null);
    return ans;
  }

  public void dfs(TreeNode root, TreeNode par) {
    if (root != null) {
      dfs(root.left, root);
      dfs(root.right, root);
      if (par == null && !set.contains(root) || !set.contains(root.left) || !set.contains(root.right)) {
        ans++;
        set.add(root);
        set.add(par);
        set.add(root.left);
        set.add(root.right);
      }
    }
  }
}
