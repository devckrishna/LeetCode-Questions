import java.util.LinkedList;
import java.util.Queue;

public class Codec {
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

  public void traverse(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append("#");
      return;
    }
    sb.append(root.val);
    traverse(root.left, sb);
    traverse(root.right, sb);
  }

  public TreeNode solve(Queue<Character> qu) {
    Character ch = qu.remove();
    if (ch == '#') {
      return null;
    } else {
      TreeNode root = new TreeNode(ch - '0');
      root.left = solve(qu);
      root.right = solve(qu);
      return root;
    }

  }

  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    traverse(root, sb);
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    Queue<Character> qu = new LinkedList<>();
    for (char ch : data.toCharArray()) {
      qu.add(ch);
    }
    return solve(qu);

  }
}
