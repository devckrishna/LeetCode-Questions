class OddEvenLL {
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

  public ListNode oddEvenList(ListNode head) {
    ListNode oddHead = new ListNode(0);
    ListNode odd = oddHead;
    ListNode evenHead = new ListNode(0);
    ListNode even = evenHead;
    ListNode curr = head;
    int i = 0;
    while (curr != null) {
      if (i % 2 == 0) {
        even.next = curr;
        even = even.next;
      } else {
        odd.next = curr;
        odd = odd.next;
      }
      i++;
      curr = curr.next;
    }
    even.next = oddHead.next;
    odd.next = null;
    return evenHead.next;
  }
}