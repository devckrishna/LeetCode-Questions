public class ReorderList {
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

  public ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  public void merge(ListNode l1, ListNode l2) {
    while (l1 != null) {
      ListNode l1Next = l1.next;
      ListNode l2Next = l2.next;

      l1.next = l2;
      if (l1Next == null) {
        break;
      }
      l2.next = l1Next;
      l2.next = l2Next;
      l1.next = l1Next;
    }
  }

  public void reorderList(ListNode head) {
    if (head == null) {
      return;
    }
    ListNode curr = head;
    ListNode slow = head;
    ListNode fast = head;
    ListNode prev = null;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    prev.next = null;
    ListNode rev = reverse(slow);
    merge(curr, rev);
  }
}
