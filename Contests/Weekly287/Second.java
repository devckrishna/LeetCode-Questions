import java.util.*;

public class Second {
  public List<List<Integer>> findWinners(int[][] matches) {
    Map<Integer, Integer> lost = new HashMap<>();
    for (int[] curr : matches) {
      lost.put(curr[1], lost.getOrDefault(curr[1], 0) + 1);
    }
    List<Integer> first = new ArrayList<>();
    List<Integer> second = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    for (int[] curr : matches) {
      if (!lost.containsKey(curr[0]) && !set.contains(curr[0])) {
        first.add(curr[0]);
        set.add(curr[0]);
      }
      if (lost.containsKey(curr[1]) && lost.get(curr[1]) == 1) {
        second.add(curr[1]);
      }
    }
    List<List<Integer>> ans = new ArrayList<>();
    Collections.sort(first);
    Collections.sort(second);
    ans.add(first);
    ans.add(second);
    return ans;
  }
}
