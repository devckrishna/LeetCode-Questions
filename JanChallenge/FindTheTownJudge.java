import java.util.*;

public class FindTheTownJudge {
  public int findJudge(int n, int[][] trust) {
    if (trust.length == 0 && n == 1) {
      return 1;
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int[] curr : trust) {
      map.put(curr[0], map.getOrDefault(curr[0], 0) - 1);
      map.put(curr[1], map.getOrDefault(curr[1], 0) + 1);
    }
    for (int temp : map.keySet()) {
      if (map.get(temp) == n - 1) {
        return temp;
      }
    }
    return -1;
  }
}