import java.util.*;

public class ArrayOfDoubledPairs {
  public boolean canReorderDoubled(int[] A) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
      return Math.abs(a) - Math.abs(b);
    });
    for (int num : A) {
      pq.offer(num);
    }
    while (!pq.isEmpty()) {
      Integer num = pq.poll();
      if (!pq.remove(num * 2))
        return false;
    }
    return true;
  }
}
