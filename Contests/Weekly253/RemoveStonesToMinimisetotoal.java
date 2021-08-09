import java.util.Collections;
import java.util.PriorityQueue;

public class RemoveStonesToMinimisetotoal {
  public int minStoneSum(int[] piles, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int curr : piles) {
      pq.offer(curr);
    }
    while (k-- > 0) {
      int temp = pq.poll();
      pq.add(temp - temp / 2);
    }
    int ans = 0;
    while (!pq.isEmpty()) {
      ans += pq.poll();
    }
    return ans;
  }
}
