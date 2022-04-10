import java.util.PriorityQueue;

public class Third {
  int mod = 1000000007;

  public int maximumProduct(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int num : nums) {
      pq.add(num);
    }
    while (k-- > 0) {
      int temp = pq.poll();
      temp++;
      pq.add(temp);
    }
    long ans = 1;
    while (!pq.isEmpty()) {
      ans = (ans * pq.poll()) % mod;
    }
    return (int) ans;
  }
}
