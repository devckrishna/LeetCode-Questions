import java.util.*;

public class KDiffPairsInArray {
  public int findPairs(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int ans = 0;
    for (int curr : map.keySet()) {
      if ((k > 0 && map.containsKey(curr + k)) || (k == 0 && map.get(curr) > 1)) {
        ans++;
      }
    }
    return ans;
  }
}
