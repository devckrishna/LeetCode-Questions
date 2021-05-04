public class ConverSortedListToBST {
  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

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

  public TreeNode sortedListToBST(ListNode head) {
    ListNode curr = head;
    int count = 0;
    while (curr != null) {
      count++;
      curr = curr.next;
    }

    int[] arr = new int[count];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = head.val;
      head = head.next;
    }
    return solve(arr, 0, count - 1);
  }

  public static TreeNode solve(int[] arr, int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = (start + end) / 2;
    TreeNode root = new TreeNode(arr[mid]);

    root.left = solve(arr, start, mid - 1);
    root.right = solve(arr, mid + 1, end);

    return root;
  }
}
