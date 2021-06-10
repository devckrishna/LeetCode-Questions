class MergeKLL {
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

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode temp = new ListNode(0);
    ListNode l3 = temp;
    ListNode first = l1;
    ListNode second = l2;
    while (first != null && second != null) {
      if (first.val <= second.val) {
        l3.next = new ListNode(first.val);
        first = first.next;
      } else {
        l3.next = new ListNode(second.val);
        second = second.next;
      }
      l3 = l3.next;
    }
    if (first != null) {
      l3.next = first;
    }
    if (second != null) {
      l3.next = second;
    }
    return temp.next;
  }

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }
    ListNode ans = lists[0];
    for (int i = 1; i < lists.length; i++) {
      ans = mergeTwoLists(ans, lists[i]);
    }
    return ans;
  }
}