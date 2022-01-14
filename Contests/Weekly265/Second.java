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

  public int[] nodesBetweenCriticalPoints(ListNode head) {
    if (head == null || head.next == null || head.next.next == null || head.next.next.next == null) {
      return new int[] { -1, -1 };
    }
    List<Integer> arr = new ArrayList<>();
    ListNode curr = head.next;
    ListNode prev = head;
    ListNode next = curr.next;
    int i = 1;
    while (curr.next != null) {
      if ((prev.val > curr.val && curr.val < next.val) || (prev.val < curr.val && curr.val > next.val)) {
        arr.add(i);
      }
      prev = curr;
      curr = next;
      next = next.next;
      i++;
    }
    Collections.sort(arr);

    int[] ans = new int[2];
    if (arr.size() <= 1) {
      return new int[] { -1, -1 };
    }
    int min = Integer.MAX_VALUE;
    for (int ind = 0; ind < arr.size() - 1; ind++) {
      min = Math.min(min, arr.get(ind + 1) - arr.get(ind));
    }
    ans[0] = min;
    ans[1] = arr.get(arr.size() - 1) - arr.get(0);
    return ans;
  }
}
