import java.util.*;

public class AllNodesDistanceKFromStartNode {
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

  static HashMap<TreeNode, TreeNode> parent;

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    parent = new HashMap<>();
    dfs(root, null);
    Queue<TreeNode> qu = new LinkedList<>();
    Set<TreeNode> seen = new HashSet<>();
    qu.add(null);
    qu.add(target);
    seen.add(target);
    seen.add(null);
    int dist = 0;
    while (!qu.isEmpty()) {
      TreeNode temp = qu.poll();
      if (temp == null) {
        if (dist == K) {
          List<Integer> ans = new ArrayList<>();
          for (TreeNode n : qu) {
            ans.add(n.val);
          }
          return ans;
        }
        dist++;
        qu.add(null);
      } else {
        if (!seen.contains(temp.left)) {
          seen.add(temp.left);
          qu.add(temp.left);
        }
        if (!seen.contains(temp.right)) {
          seen.add(temp.right);
          qu.add(temp.right);
        }
        TreeNode curr = parent.get(temp);
        if (!seen.contains(curr)) {
          seen.add(curr);
          qu.add(curr);
        }
      }

    }
    return new ArrayList<>();
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
