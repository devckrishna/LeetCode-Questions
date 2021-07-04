import java.util.*;

public class MaxNumberOfEventsThatCanBeAttended {
  public int maxEvents(int[][] events) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
    int index = 0;
    int ans = 0;
    for (int day = 1; day <= 100000; day++) {
      while (!pq.isEmpty() && pq.peek() < day) {
        pq.poll();
      }
      while (index < events.length && events[index][0] == day) {
        pq.add(events[index][1]);
        index++;
      }
      if (!pq.isEmpty()) {
        pq.poll();
        ans++;
      }
    }
    return ans;
  }
}
