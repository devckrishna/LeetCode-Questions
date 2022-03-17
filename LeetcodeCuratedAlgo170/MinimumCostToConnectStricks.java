import java.util.*;

public class MinimumCostToConnectStricks {
  public int connectSticks(int[] sticks) {
    int ans = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int stick : sticks) {
      pq.add(stick);
    }
    while (pq.size() != 1) {
      int first = pq.poll();
      int second = pq.poll();
      ans += first + second;
      pq.add(first + second);
    }
    return ans;
  }
}
