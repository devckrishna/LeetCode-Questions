public class SwappingNodes {
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

  public ListNode swapNodes(ListNode head, int k) {
    ListNode first = head;
    ListNode second = head;
    ListNode fast = head;
    int i = 0;
    while (fast != null && i < k) {
      fast = fast.next;
      i++;
    }
    while (fast != null) {
      second = second.next;
      fast = fast.next;
    }
    while (first != null && k-- > 1) {
      first = first.next;
    }
    int temp = first.val;
    first.val = second.val;
    second.val = temp;
    return head;
  }
}
