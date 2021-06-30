import java.util.*;

public class ZigZag {
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

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }
    Queue<TreeNode> qu = new LinkedList<>();
    qu.add(null);
    qu.add(root);
    boolean rev = false;

    while (!qu.isEmpty()) {
      TreeNode temp = qu.poll();
      if (qu.size() == 0) {
        break;
      }
      if (temp == null) {
        List<Integer> curr = new ArrayList<>();
        for (TreeNode n : qu) {
          curr.add(n.val);
        }
        if (rev) {
          Collections.reverse(curr);
        }
        rev = !rev;
        ans.add(curr);
        qu.add(null);
      } else {
        if (temp.left != null) {
          qu.add(temp.left);
        }
        if (temp.right != null) {
          qu.add(temp.right);
        }
      }
    }

    return ans;
  }
}
