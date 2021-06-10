import java.util.*;

public class BTZIGZAG {
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

  public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
    List<List<Integer>> ret = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int l = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> level = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node != null) {
          level.add(node.val);
          queue.add(node.left);
          queue.add(node.right);
        }
      }
      if (!level.isEmpty()) {
        if (l % 2 == 1) {
          Collections.reverse(level);
        }
        ret.add(level);
      }
      l++;
    }
    return ret;
  }

  // dfs recursively
  public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
    List<List<Integer>> ret = new ArrayList<>();
    dfs(root, 0, ret);
    return ret;
  }

  private void dfs(TreeNode node, int l, List<List<Integer>> ret) {
    if (node != null) {
      if (l == ret.size()) {
        List<Integer> level = new ArrayList<>();
        ret.add(level);
      }
      if (l % 2 == 1) {
        ret.get(l).add(0, node.val); // insert at the beginning
      } else {
        ret.get(l).add(node.val);
      }
      dfs(node.left, l + 1, ret);
      dfs(node.right, l + 1, ret);
    }
  }
}
