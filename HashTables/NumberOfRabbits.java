import java.util.*;

public class NumberOfRabbits {
  public int numRabbits(int[] answers) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int val : answers) {
      map.put(val, map.getOrDefault(val, 0) + 1);
    }

    int ans = 0;
    for (int key : map.keySet()) {
      int size = key + 1;
      int groups = (int) Math.ceil(map.get(key) * 1.0 / size);
      ans += size * groups;
    }
    return ans;
  }
}
