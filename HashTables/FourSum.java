import java.util.*;

public class FourSum {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (i != 0 && nums[i - 1] == nums[i]) {
        continue;
      }
      for (int j = i + 1; j < n; j++) {
        if (j != i + 1 && nums[j - 1] == nums[j]) {
          continue;
        }
        int start = j + 1;
        int end = n - 1;
        while (start < end) {
          int sum = nums[i] + nums[j] + nums[start] + nums[end];
          if (sum > target) {
            end--;
          } else if (sum < target) {
            start++;
          } else {
            ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[start], nums[end])));
            start++;
            end--;
            while (start < n && nums[start - 1] == nums[start]) {
              start++;
            }
            while (end >= 0 && nums[end] == nums[end + 1]) {
              end--;
            }
          }
        }

      }
    }
    return ans;
  }
}
