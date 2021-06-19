import java.util.*;

public class ContinuousSubArraySum {
  public boolean checkSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    int mod = 0;
    map.put(0, -1);
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      mod = sum % k;
      if (map.containsKey(mod) && i - map.get(mod) > 1) {
        return true;
      } else {
        map.putIfAbsent(mod, i);
      }
    }
    return false;
  }
}
