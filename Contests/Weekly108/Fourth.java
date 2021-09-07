import java.util.Arrays;
import java.util.PriorityQueue;

public class Fourth {
  public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
    int[][] arr = new int[n][2];
    for (int i = 0; i < n; i++) {
      arr[i] = new int[] { efficiency[i], speed[i] };
    }
    Arrays.sort(arr, (a, b) -> b[0] - a[0]);
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
    long ans = 0;
    long sum = 0;
    for (int[] curr : arr) {
      sum += curr[1];
      pq.add(curr[1]);
      if (pq.size() > k) {
        sum -= pq.poll();
      }
      ans = Math.max(ans, (sum) * curr[0]);
    }
    return (int) (ans % (long) (1e9 + 7));
  }
}
