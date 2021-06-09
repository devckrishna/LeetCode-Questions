public class BSTFRomPreOrder {
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

  public int construct(int[] preorder, TreeNode root, int len, int min, int max, int pos) {
    if (pos == len || preorder[pos] < min || preorder[pos] > max) {
      return pos;
    }
    if (preorder[pos] < root.val) {
      root.left = new TreeNode(preorder[pos]);
      pos += 1;
      pos = construct(preorder, root.left, len, min, max - 1, pos);
    }
    if (pos == len || preorder[pos] < min || preorder[pos] > max) {
      return pos;
    }
    root.right = new TreeNode(preorder[pos]);
    pos++;
    pos = construct(preorder, root.right, len, root.val + 1, max, pos);
    return pos;
  }

  public TreeNode bstFromPreorder(int[] preorder) {
    if (preorder.length == 0) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[0]);
    if (preorder.length == 1) {
      return root;
    }
    construct(preorder, root, preorder.length, Integer.MIN_VALUE, Integer.MAX_VALUE, 1);
    return root;
  }
}
