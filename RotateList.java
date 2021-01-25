class RotateList {
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

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return head;
    }
    int count = 1;
    ListNode temp = head;
    ListNode prev = head;
    while (temp.next != null) {
      temp = temp.next;
      count++;
    }
    k = k % count;
    for (int i = 0; i < count - k - 1; i++) {
      prev = prev.next;
    }
    if (k == 0) {
      return head;
    } else {
      temp.next = head;
      head = prev.next;
      prev.next = null;
    }
    return head;
  }
}