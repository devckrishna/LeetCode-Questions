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

  public ListNode mergeNodes(ListNode head) {

    ListNode t = head;
    List<Integer> list = new ArrayList<>();
    int sum = 0;
    while (t != null) {
      if (t.val == 0) {
        if (sum != 0) {
          list.add(sum);
          sum = 0;
        }
      }
      sum += t.val;
      t = t.next;
    }

    ListNode root = null;
    for (int i = list.size() - 1; i >= 0; i--)
      root = insert(root, list.get(i));
    return root;
  }

  public ListNode insert(ListNode root, int item) {
    ListNode temp = new ListNode();
    temp.val = item;
    temp.next = root;
    root = temp;
    return root;
  }
}
