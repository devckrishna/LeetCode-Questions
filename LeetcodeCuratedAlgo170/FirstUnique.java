import java.util.*;

public class FirstUnique {
  Map<Integer, Integer> freq = new HashMap<>();
  Queue<Integer> q = new LinkedList<>();

  public FirstUnique(int[] nums) {
    for (int x : nums)
      add(x);
  }

  public int showFirstUnique() {
    while (!q.isEmpty() && freq.get(q.peek()) > 1)
      q.poll();
    return q.isEmpty() ? -1 : q.peek();
  }

  public void add(int value) {
    freq.put(value, freq.getOrDefault(value, 0) + 1);
    q.offer(value);
  }
}
