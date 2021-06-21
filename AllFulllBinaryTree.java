import java.util.*;

public class AllFulllBinaryTree {
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

  public List<TreeNode> allPossibleFBT(int N) {
    return allPossibleFBTHelper(N, new HashMap<>());
  }

  private List<TreeNode> allPossibleFBTHelper(int N, Map<Integer, List<TreeNode>> memory) {
    if (memory.containsKey(N)) {
      return memory.get(N);
    }

    List<TreeNode> trees = new ArrayList<>();

    if (N - 1 == 0) {
      trees.add(new TreeNode(0));
    } else if (N % 2 != 0) {
      int target = N - 1;
      Map<Integer, List<TreeNode>> possibleSubtrees = new HashMap<>();

      for (int i = 1; i < target; i += 2) {
        possibleSubtrees.put(i, allPossibleFBTHelper(i, memory));
      }

      for (int i = 1; i < target; i += 2) {
        List<TreeNode> leftRoots = possibleSubtrees.get(i);
        List<TreeNode> rightRoots = possibleSubtrees.get(target - i);

        for (TreeNode leftRoot : leftRoots) {
          for (TreeNode rightRoot : rightRoots) {
            trees.add(new TreeNode(0, leftRoot, rightRoot));
          }
        }
      }
    }

    memory.put(N, trees);
    return trees;

  }
}
