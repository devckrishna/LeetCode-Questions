import java.util.*;

public class FindDuplicateSubTrees {
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

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();
    solve(root, map, ans);
    return ans;
  }

  public String solve(TreeNode root, Map<String, Integer> map, List<TreeNode> ans) {
    if (root == null) {
      return "*";
    }
    StringBuilder key = new StringBuilder();
    key.append("L").append(solve(root.left, map, ans)).append(root.val).append("R").append(solve(root.right, map, ans));

    int curr = map.getOrDefault(key.toString(), 0);
    if (curr == 1) {
      ans.add(root);
    }
    map.put(key.toString(), curr + 1);
    return key.toString();
  }

}