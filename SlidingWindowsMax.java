import java.util.*;

public class SlidingWindowsMax {
  static class Node implements Comparable<Node> {
    int index;
    int val;

    public Node(int val, int index) {
      this.val = val;
      this.index = index;
    }

    @Override
    public int compareTo(SlidingWindowsMax.Node o) {
      return this.val - o.val;
    }
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    PriorityQueue<Node> pq = new PriorityQueue<>(Collections.reverseOrder());
    int[] ans = new int[nums.length - k + 1];
    for (int i = 0; i < nums.length; i++) {
      while (!pq.isEmpty() && pq.peek().index <= (i - k)) {
        pq.poll();
      }
      pq.offer(new Node(nums[i], i));
      if (i >= k - 1) {
        ans[i - k + 1] = pq.peek().val;
      }
    }
    return ans;
  }
}
