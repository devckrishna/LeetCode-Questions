import java.util.*;

public class FindMode {
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

  private Map<Integer, Integer> hashMap = new HashMap<>();
  private int max = 1;

  public int[] findMode(TreeNode root) {
    if (root == null) {
      return new int[0];
    }
    helper(root);
    int result[] = new int[hashMap.size()];
    int i = 0;
    for (Integer k : hashMap.keySet()) {
      if (hashMap.get(k) == max)
        result[i++] = k;
    }
    return Arrays.copyOf(result, i);
  }

  private void helper(TreeNode root) {
    if (root != null) {
      if (hashMap.containsKey(root.val)) {
        int count = hashMap.get(root.val) + 1;
        hashMap.put(root.val, hashMap.get(root.val) + 1);
        max = Math.max(max, count);
      } else
        hashMap.put(root.val, 1);
      helper(root.left);
      helper(root.right);
    }
  }
}
