import java.util.*;

class LLComponents {
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

  public int numComponents(ListNode head, int[] G) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < G.length; i++) {
      set.add(G[i]);
    }
    ListNode curr = head;
    int components = 0;
    while (curr != null) {
      if (set.contains(curr.val) && (curr.next == null || !set.contains(curr.next.val))) {
        components++;
      }
      curr = curr.next;
    }
    return components;
  }
}