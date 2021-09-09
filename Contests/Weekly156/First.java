import java.util.*;

public class First {
  public boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    for (int i : arr) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    for (int curr : map.keySet()) {
      set.add(map.get(curr));
    }
    return set.size() == map.size();
  }
}