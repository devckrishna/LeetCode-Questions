import java.util.Collections;
import java.util.PriorityQueue;

public class Third {
  public int halveArray(int[] nums) {
    PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
    double sum = 0;
    for (int num : nums) {
      sum += num;
      pq.add(num * 1.0);
    }
    double currSum = sum;
    sum /= 2;
    int ans = 0;
    while (currSum > sum) {
      double curr = pq.poll();
      curr /= 2;
      currSum -= curr;
      pq.add(curr);
      ans++;
    }
    return ans;
  }
}
