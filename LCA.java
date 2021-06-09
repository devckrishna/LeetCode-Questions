import java.util.*;

public class LCA {
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

  static TreeNode ans;

  public boolean traverse(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return false;
    }
    int left = traverse(root.left, p, q) ? 1 : 0;
    int right = traverse(root.right, p, q) ? 1 : 0;

    int mid = (root == p || root == q) ? 1 : 0;
    if (left + right + mid >= 2) {
      ans = root;
    }
    return (left + right + mid > 0);
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    ans = null;
    traverse(root, p, q);
    return ans;
  }

  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    Map<TreeNode, TreeNode> parent = new HashMap<>();

    parent.put(root, null);
    stack.push(root);

    while (!parent.containsKey(p) || !parent.containsKey(q)) {

      TreeNode node = stack.pop();

      if (node.left != null) {
        parent.put(node.left, node);
        stack.push(node.left);
      }
      if (node.right != null) {
        parent.put(node.right, node);
        stack.push(node.right);
      }
    }

    Set<TreeNode> ancestors = new HashSet<>();

    while (p != null) {
      ancestors.add(p);
      p = parent.get(p);
    }

    while (!ancestors.contains(q))
      q = parent.get(q);
    return q;
  }
}
