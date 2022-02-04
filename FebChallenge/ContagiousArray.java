import java.util.*;

public class ContagiousArray {
  public int findMaxLength(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        nums[i] = -1;
      }
    }
    int ans = 0;
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 0);
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (map.containsKey(sum)) {
        ans = Math.max(ans, i - map.get(sum) + 1);
      } else {
        map.put(sum, i + 1);
      }
    }
    return ans;
  }
}
