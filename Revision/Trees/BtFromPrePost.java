public class BtFromPrePost {
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

  int preIndex = 0;
  int postIndex = 0;

  public TreeNode constructFromPrePost(int[] pre, int[] post) {
    TreeNode root = new TreeNode(pre[preIndex++]);
    if (root.val != post[postIndex]) {
      root.left = constructFromPrePost(pre, post);
    }
    if (root.val != post[postIndex]) {
      root.right = constructFromPrePost(pre, post);
    }
    postIndex++;
    return root;
  }
}
