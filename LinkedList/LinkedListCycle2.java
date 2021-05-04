public class LinkedListCycle2 {
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

  public ListNode detectCycle(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode target = head;
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        while (target != fast) {
          fast = fast.next;
          target = target.next;
        }
        return target;
      }
    }
    return null;
  }

}
