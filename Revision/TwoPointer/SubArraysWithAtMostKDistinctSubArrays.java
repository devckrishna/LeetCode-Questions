import java.util.*;

public class SubArraysWithAtMostKDistinctSubArrays {
  public int subarraysWithKDistinct(int[] nums, int k) {
    return solve(nums, k) - solve(nums, k - 1);
  }

  public int solve(int[] nums, int k) {
    int i = -1;
    int j = -1;
    int ans = 0;
    Map<Integer, Integer> map = new HashMap<>();

    while (true) {
      while (i < nums.length - 1) {
        i++;
        int temp = nums[i];
        map.put(temp, map.getOrDefault(temp, 0) + 1);
        if (map.size() <= k) {
          ans += i - j;
        } else {
          break;
        }
      }
      if (i == nums.length - 1 && map.size() <= k) {
        break;
      }
      while (j < i) {
        j++;
        int temp = nums[j];
        if (map.get(temp) == 1) {
          map.remove(temp);
        } else {
          map.put(temp, map.get(temp) - 1);
        }
        if (map.size() > k) {
          continue;
        } else {
          ans += i - j;
          break;
        }
      }
    }
    return ans;
  }
}
