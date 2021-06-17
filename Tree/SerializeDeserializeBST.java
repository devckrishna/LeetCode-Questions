import java.util.*;

public class SerializeDeserializeBST {
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

  public String serialize(TreeNode root) {

    if (root == null)
      return null;

    // String result = null;
    StringBuilder tree = new StringBuilder();

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {

      TreeNode node = q.poll();
      if (node != null) {
        tree.append(node.val);
        tree.append(" ");

        q.add(node.left);
        q.add(node.right);

      } else {
        tree.append("null");
        tree.append(" ");
      }

    }
    return tree.toString().trim();
  }

  public TreeNode deserialize(String data) {
    if (data == null)
      return null;

    String[] nodes = data.split(" ");
    int i = 0;
    TreeNode root = toNode(nodes, i++);

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while (i < nodes.length) {
      int size = q.size();
      while (size-- > 0 && i < nodes.length) {

        TreeNode node = q.poll();
        node.left = toNode(nodes, i++);
        node.right = toNode(nodes, i++);

        if (node.left != null) {
          q.add(node.left);
        }

        if (node.right != null) {
          q.add(node.right);
        }

      }
    }
    return root;
  }

  private TreeNode toNode(String[] nodes, int index) {

    if (index >= nodes.length || "null".equals(nodes[index]))
      return null;

    return new TreeNode(Integer.parseInt(nodes[index]));
  }
}
