public class PathSum2 {
  static class TreeNode {
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

  public int pathSum(TreeNode root, int sum) {
    int curCount = isMeetSum(root, sum);
    if (root == null) {
      return 0;
    }

    return curCount + pathSum(root.left, sum) + pathSum(root.right, sum);
  }

  public int isMeetSum(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }
    int count = 0;
    if (root.val == sum) {
      count++;
    }
    return count + isMeetSum(root.left, sum - root.val) + isMeetSum(root.right, sum - root.val);
  }
}
