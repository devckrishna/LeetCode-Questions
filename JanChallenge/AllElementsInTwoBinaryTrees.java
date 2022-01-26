import java.util.*;

public class AllElementsInTwoBinaryTrees {
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

  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    List<Integer> first = new ArrayList<>();
    List<Integer> second = new ArrayList<>();

    inorder(root1, first);
    inorder(root2, second);

    return merge(first, second);
  }

  private void inorder(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }

    inorder(root.left, list);
    list.add(root.val);
    inorder(root.right, list);
  }

  private List<Integer> merge(List<Integer> first, List<Integer> second) {
    List<Integer> ans = new ArrayList<>();

    int i = 0;
    int j = 0;

    while (i < first.size() && j < second.size()) {
      if (first.get(i) < second.get(j)) {
        ans.add(first.get(i++));
      } else {
        ans.add(second.get(j++));
      }
    }

    if (i != first.size()) {
      while (i < first.size()) {
        ans.add(first.get(i++));
      }
    } else if (j != second.size()) {
      while (j < second.size()) {
        ans.add(second.get(j++));
      }
    }

    return ans;
  }
}
