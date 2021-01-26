class SwappingNodeLL {
  public static class ListNode {
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

  public ListNode swapNodes(ListNode head, int k) {
    ListNode dummy = new ListNode(0, head);

    ListNode slow = new ListNode();
    ListNode fast = new ListNode();
    while (k-- > 0) {
      slow = head;
      head = head.next;
    }
    fast = dummy.next;
    while (head != null) {
      fast = fast.next;
      head = head.next;
    }
    int temp = slow.val;
    slow.val = fast.val;
    fast.val = temp;
    return dummy.next;
  }
}