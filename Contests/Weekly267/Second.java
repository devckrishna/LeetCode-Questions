public class Second {
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

  public ListNode reverseEvenLengthGroups(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode ptr = head;
    int total = 0;
    while (ptr != null) {
      total++;
      ptr = ptr.next;
    }

    int numOfNodes = 1;
    ListNode cur = head, pre = null;
    while (cur != null) {
      numOfNodes = Math.min(numOfNodes, total);
      total -= numOfNodes;
      if (numOfNodes % 2 == 1) {
        int cnt = 0;
        while (cur != null && cnt++ < numOfNodes) {
          pre = cur;
          cur = cur.next;
        }
      } else {
        ListNode[] res = reverseList(cur, numOfNodes);
        pre.next = res[0];
        pre = cur;
        cur = res[1];
      }
      numOfNodes++;
    }
    return head;
  }

  private ListNode[] reverseList(ListNode node, int n) {
    ListNode pre = null, cur = node, post = null;
    while (n-- > 0) {
      post = cur.next;
      cur.next = pre;
      pre = cur;
      cur = post;
    }
    node.next = cur;
    return new ListNode[] { pre, post };
  }
}
