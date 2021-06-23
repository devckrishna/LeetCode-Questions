import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxPerformanceOfTheTeams {
  public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
    int[][] performance = new int[n][2];
    for (int i = 0; i < performance.length; i++) {
      performance[i][0] = efficiency[i];
      performance[i][1] = speed[i];
    }
    Arrays.sort(performance, (a, b) -> b[0] - a[0]);
    PriorityQueue<Integer> qu = new PriorityQueue<>((a, b) -> a - b);
    long sum = 0;
    long ans = 0;
    for (int[] per : performance) {
      qu.add(per[1]);
      sum += per[1];
      if (qu.size() > k) {
        sum -= qu.poll();
      }
      ans = Math.max(ans, sum * per[0]);
    }
    return (int) (ans % (long) (Math.pow(10, 9) + 7));
  }
}
