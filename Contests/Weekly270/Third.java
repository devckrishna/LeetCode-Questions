import java.util.*;

public class Third {
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

  public String getDirections(TreeNode root, int startValue, int destValue) {

    Map<Integer, TreeNode> map = new HashMap<>();
    Map<Integer, Integer> parentMap = new HashMap<>();
    StringBuilder sb = new StringBuilder();

    parentMap.put(root.val, null);
    preorder(root, map, parentMap);

    TreeNode ancestor = lca(root, map.get(startValue), map.get(destValue));

    TreeNode baseNode = map.get(startValue);

    if (baseNode != ancestor) {
      while (baseNode != ancestor) {
        baseNode = map.get(parentMap.get(baseNode.val));
        sb.append("U");
      }
    }

    TreeNode destNode = map.get(destValue);
    int position = sb.length();

    if (destNode != ancestor) {
      while (destNode != ancestor) {
        TreeNode destNodeParent = map.get(parentMap.get(destNode.val));
        if (destNodeParent != null && destNodeParent.left == destNode) {
          sb.insert(position, "L");
        } else {
          sb.insert(position, "R");
        }
        destNode = destNodeParent;
      }
    }

    return sb.toString();
  }

  private void preorder(TreeNode root, Map<Integer, TreeNode> map, Map<Integer, Integer> parentMap) {
    if (root == null)
      return;

    map.put(root.val, root);
    if (root.left != null)
      parentMap.put(root.left.val, root.val);
    if (root.right != null)
      parentMap.put(root.right.val, root.val);
    preorder(root.left, map, parentMap);
    preorder(root.right, map, parentMap);
  }

  private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q)
      return root;
    TreeNode left = lca(root.left, p, q);
    TreeNode right = lca(root.right, p, q);
    if (left != null && right != null)
      return root;
    return left == null ? right : left;
  }
}
