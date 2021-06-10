import java.util.*;

public class SerializeDeserialize {
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
    return serial(new StringBuilder(), root).toString();
  }

  // Generate preorder string
  private StringBuilder serial(StringBuilder str, TreeNode root) {
    if (root == null)
      return str.append("#");
    str.append(root.val).append(",");
    serial(str, root.left).append(",");
    serial(str, root.right);
    return str;
  }

  public TreeNode deserialize(String data) {
    return deserial(new LinkedList<>(Arrays.asList(data.split(","))));
  }

  // Use queue to simplify position move
  private TreeNode deserial(Queue<String> q) {
    String val = q.poll();
    if ("#".equals(val))
      return null;
    TreeNode root = new TreeNode(Integer.valueOf(val));
    root.left = deserial(q);
    root.right = deserial(q);
    return root;
  }
}
