import java.util.Random;

public class LLRandomNode {
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

  int count = 0;
  ListNode head;

  public LLRandomNode(ListNode head) {
    this.head = head;
    ListNode tem = head;
    while (tem != null) {
      count++;
      tem = tem.next;
    }
  }

  public int getRandom() {
    ListNode fakehead = head;
    Random r = new Random();
    int random = r.nextInt(count);
    for (int i = 0; i < random; i++) {
      fakehead = fakehead.next;
    }
    return fakehead.val;
  }
}
