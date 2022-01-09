import java.util.*;

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

  public ListNode reverseList(ListNode head) {
    ListNode curr = head;
    ListNode prev = null;
    while (curr != null) {
      ListNode temp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = temp;
    }
    return prev;
  }

  public int pairSum(ListNode head) {
    List<Integer> arr = new ArrayList<>();
    ListNode temp = head;
    while (temp != null) {
      arr.add(temp.val);
      temp = temp.next;
    }
    ListNode curr = reverseList(head);
    int ans = 0;
    int index = 0;
    while (curr != null) {
      ans = Math.max(ans, curr.val + arr.get(index));
      index++;
      curr = curr.next;
    }
    return ans;
  }
}
