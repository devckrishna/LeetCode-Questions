import java.util.*;

public class HighFive {
  public int[][] highFive(int[][] items) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int[] item : items) {
      if (!map.containsKey(item[0])) {
        map.put(item[0], new ArrayList<>());
      }
      map.get(item[0]).add(item[1]);
    }
    int[][] ans = new int[map.size()][2];
    int index = 0;
    for (int curr : map.keySet()) {
      List<Integer> arr = map.get(curr);
      Collections.sort(arr, Collections.reverseOrder());
      int sum = 0;
      for (int i = 0; i < 5; i++) {
        sum += arr.get(i);
      }
      ans[index++] = new int[] { curr, sum / 5 };
    }
    return ans;
  }
}