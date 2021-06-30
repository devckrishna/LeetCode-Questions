import java.util.*;

public class AllNodesDistanceKInBinaryTree {
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

  Map<TreeNode, TreeNode> parent;

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    parent = new HashMap<>();
    dfs(root, null);

    List<Integer> ans = new ArrayList<>();
    Queue<TreeNode> qu = new LinkedList<>();
    Set<TreeNode> visited = new HashSet<>();
    visited.add(null);
    visited.add(target);
    qu.add(null);
    qu.add(target);

    int dist = 0;
    while (!qu.isEmpty()) {
      TreeNode temp = qu.poll();
      if (temp == null) {
        if (dist == k) {
          for (TreeNode n : qu) {
            ans.add(n.val);
          }
          return ans;
        }
        qu.add(null);
        dist++;
      } else {
        if (!visited.contains(temp.left)) {
          visited.add(temp.left);
          qu.add(temp.left);
        }
        if (!visited.contains(temp.right)) {
          visited.add(temp.right);
          qu.add(temp.right);
        }
        TreeNode par = parent.get(temp);
        if (!visited.contains(par)) {
          visited.add(par);
          qu.add(par);
        }
      }
    }
    return null;
  }

  public void dfs(TreeNode root, TreeNode par) {
    if (root == null) {
      return;
    }
    parent.put(root, par);
    dfs(root.left, root);
    dfs(root.right, root);
  }
}
