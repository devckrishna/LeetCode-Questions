class SwapNodeInPairs {
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

  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode curr = head.next;
    ListNode prev = head;
    head = curr;
    while (curr.next != null) {
      ListNode next = curr.next;
      curr.next = prev;
      if (next == null || next.next == null) {
        prev.next = next;
        break;
      }
      prev.next = next.next;
      prev = next;
      curr = prev.next;
    }
    return head;
  }
}