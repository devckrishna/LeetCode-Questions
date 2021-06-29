import java.util.*;

public class CountSmallerNumbersAfterSelf {
  class Node {
    Node left;
    Node right;
    int val;
    int sum;
    int dup = 1;

    public Node(int val, int sum) {
      this.val = val;
      this.sum = sum;
    }
  }

  public List<Integer> countSmaller(int[] nums) {
    Integer[] ans = new Integer[nums.length];
    Node root = null;
    for (int i = nums.length - 1; i >= 0; i--) {
      root = insert(root, nums[i], ans, i, 0);
    }

    return Arrays.asList(ans);
  }

  public Node insert(Node root, int num, Integer[] ans, int i, int preSum) {
    if (root == null) {
      root = new Node(num, 0);
      ans[i] = preSum;
    } else if (root.val == num) {
      root.dup++;
      ans[i] = preSum + root.sum;
    } else if (root.val > num) {
      root.sum++;
      root.left = insert(root.left, num, ans, i, preSum);
    } else {
      root.right = insert(root.right, num, ans, i, preSum + root.sum + root.dup);
    }

    return root;
  }
}
