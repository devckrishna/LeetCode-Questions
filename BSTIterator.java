import java.util.*;

public class BSTIterator {
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

  TreeNode curr;
  List<TreeNode> inList;
  int index;

  public BSTIterator(TreeNode root) {
    curr = root;
    index = 0;
    inList = new ArrayList<>();
    solve(curr);
  }

  public void solve(TreeNode curr) {
    if (curr == null) {
      return;
    }
    solve(curr.left);
    inList.add(curr);
    solve(curr.right);
  }

  public int next() {
    int ans = inList.get(index).val;
    index++;
    return ans;
  }

  public boolean hasNext() {
    return index < inList.size();
  }
}
