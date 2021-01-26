import java.util.*;

class AddTwoNumbers2 {
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

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    while (l1 != null) {
      s1.push(l1.val);
      l1 = l1.next;
    }

    while (l2 != null) {
      s2.push(l2.val);
      l2 = l2.next;
    }

    ListNode ans = null;
    int carry = 0;
    while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
      int first = s1.isEmpty() ? 0 : s1.pop();
      int second = s2.isEmpty() ? 0 : s2.pop();
      int sum = first + second + carry;
      ListNode newNode = new ListNode(sum % 10);
      newNode.next = ans;
      ans = newNode;
      carry = sum / 10;

    }
    return ans;
  }

}