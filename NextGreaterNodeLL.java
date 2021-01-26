import java.util.*;

class NextGreaterNodeLL {
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

  static int len = 0;

  public int[] nextLargerNodes(ListNode head) {
    Stack<Integer> st = new Stack<Integer>();
    head = reverse(head);
    int[] result = new int[len];
    int i = len - 1;
    while (head != null) {
      if (st.isEmpty()) {
        st.push(head.val);
      } else {
        while (!st.isEmpty() && st.peek() <= head.val)
          st.pop();
        result[i] = st.isEmpty() ? 0 : st.peek();
        st.push(head.val);
      }
      head = head.next;
      i--;
    }
    return result;
  }

  public ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      len++;
      ListNode temp = head.next;
      head.next = prev;
      prev = head;
      head = temp;
    }
    return prev;
  }

}