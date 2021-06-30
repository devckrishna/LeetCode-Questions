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

  private final Stack<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    stack = new Stack<>();
    TreeNode cur = root;
    while (cur != null) {
      stack.push(cur);
      cur = cur.left;
    }
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }

  public int next() {
    TreeNode node = stack.pop();

    TreeNode cur = node.right;
    while (cur != null) {
      stack.push(cur);
      cur = cur.left;
    }

    return node.val;
  }
}
