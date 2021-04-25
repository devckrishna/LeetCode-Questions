import java.util.*;

public class AddOneRowToTree {
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

  public static void traverseToDepth(TreeNode root, int depth, int val, int currDepth) {
    if (root == null) {
      return;
    }
    if (currDepth == depth - 1) {
      TreeNode curr = root.left;
      root.left = new TreeNode(val);
      root.left.left = curr;
      curr = root.right;
      root.right = new TreeNode(val);
      root.right.right = curr;
    } else {
      traverseToDepth(root.left, depth, val, currDepth + 1);
      traverseToDepth(root.right, depth, val, currDepth + 1);
    }
  }

  public TreeNode addOneRow(TreeNode root, int val, int depth) {
    if (depth == 1) {
      TreeNode r = new TreeNode(val);
      r.left = root;
      return r;
    }
    traverseToDepth(root, depth, val, 1);
    return root;
  }

  public TreeNode addOneRow2(TreeNode t, int v, int d) {
    if (d == 1) {
      TreeNode n = new TreeNode(v);
      n.left = t;
      return n;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(t);
    int depth = 1;
    while (depth < d - 1) {
      Queue<TreeNode> temp = new LinkedList<>();
      while (!queue.isEmpty()) {
        TreeNode node = queue.remove();
        if (node.left != null)
          temp.add(node.left);
        if (node.right != null)
          temp.add(node.right);
      }
      queue = temp;
      depth++;
    }
    while (!queue.isEmpty()) {
      TreeNode node = queue.remove();
      TreeNode temp = node.left;
      node.left = new TreeNode(v);
      node.left.left = temp;
      temp = node.right;
      node.right = new TreeNode(v);
      node.right.right = temp;
    }
    return t;
  }
}