public class InsertionSortList {
  static public class ListNode {
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

  public ListNode insertionSortList(ListNode A) {
    ListNode start = new ListNode(0);
    start.next = A;
    ListNode curr = A;
    ListNode prev = start;
    ListNode temp = null;
    while (curr != null) {
      if (curr.next != null && curr.next.val < curr.val) {
        while (prev.next != null && prev.next.val < curr.next.val) {
          prev = prev.next;
        }
        temp = prev.next;
        prev.next = curr.next;
        curr.next = curr.next.next;
        prev.next.next = temp;
        prev = start;
      } else {
        curr = curr.next;
      }
    }
    return start.next;
  }
}
