
import java.util.*;

class inOrderTraversal {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inHelper(root, res);
        return res;
    }

    public static void inHelper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inHelper(root.left, res);
        }
        res.add(root.val);
        if (root.right != null) {
            inHelper(root.right, res);
        }
    }
}