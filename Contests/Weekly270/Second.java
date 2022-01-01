public class Second {
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

  public int solve(ListNode head) {
    int count = 0;
    while (head != null) {
      head = head.next;
      count++;
    }
    return count;
  }

  public ListNode deleteMiddle(ListNode head) {
    if (head == null)
      return null;
    if (head.next == null) {
      return null;
    }
    ListNode ans = head;

    int count = solve(head);

    int mid = count / 2;

    while (mid-- > 1) {
      head = head.next;
    }

    head.next = head.next.next;

    return ans;
  }
}
