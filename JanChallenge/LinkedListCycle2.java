public class LinkedListCycle2 {
  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode detectCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    boolean flag = false;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast) {
        flag = true;
        break;
      }
    }
    if (!flag) {
      return null;
    }
    ListNode curr = head;
    while (curr != slow) {
      curr = curr.next;
      slow = slow.next;
    }
    return curr;
  }
}
