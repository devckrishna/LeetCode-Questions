import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
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

  Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();

  public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    solve(root, 0, 0);
    for (int x : map.keySet()) {
      List<Integer> temp = new ArrayList<>();
      for (int y : map.get(x).keySet()) {
        temp.addAll(map.get(x).get(y));
      }
      ans.add(temp);
    }
    return ans;
  }

  public void solve(TreeNode root, int x, int y) {
    if (root == null) {
      return;
    }
    if (!map.containsKey(x)) {
      Map<Integer, List<Integer>> temp = new TreeMap<>();
      map.put(x, temp);
    }
    if (!map.get(x).containsKey(y)) {
      List<Integer> temp = new ArrayList<>();
      temp.add(root.val);
      map.get(x).put(y, temp);
    } else {
      map.get(x).get(y).add(root.val);
    }
    solve(root.left, x - 1, y + 1);
    solve(root.right, x + 1, y + 1);
  }
}
