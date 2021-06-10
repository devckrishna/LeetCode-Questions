class SortedArrayToBST {
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

  public TreeNode sortedArrayToBST(int[] nums) {
    return sortedArrayToBST(nums, 0, nums.length - 1);
  }

  private TreeNode sortedArrayToBST(int[] nums, int startIndex, int endIndex) {
    if (startIndex <= endIndex) {
      int mid = (startIndex + endIndex) / 2;
      TreeNode node = new TreeNode(nums[mid]);
      node.left = sortedArrayToBST(nums, startIndex, mid - 1);
      node.right = sortedArrayToBST(nums, mid + 1, endIndex);
      return node;
    }
    return null;
  }
}