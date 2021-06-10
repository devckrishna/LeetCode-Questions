import java.util.*;

class MaxDepth {
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

  public int maxDepth(TreeNode root) {
    int max = 0;
    if (root == null) {
      return 0;
    }
    Stack<TreeNode> path = new Stack<>();
    Stack<Integer> sub = new Stack<>();
    path.push(root);
    sub.push(1);
    while (!path.isEmpty()) {
      TreeNode temp = path.pop();
      int tempVal = sub.pop();
      if (temp.left == null && temp.right == null) {
        max = Math.max(max, tempVal);
      } else {
        if (temp.left != null) {
          path.push(temp.left);
          sub.push(tempVal + 1);
        }
        if (temp.right != null) {
          path.push(temp.right);
          sub.push(tempVal + 1);
        }
      }
    }
    return max;
  }
}