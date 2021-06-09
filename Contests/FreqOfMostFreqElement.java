import java.util.Arrays;

public class FreqOfMostFreqElement {
  public int maxFrequency(int[] nums, int k) {
    Arrays.sort(nums);
    int ans = 1;
    int left = 0;
    int right = 0;
    long sum = 0;
    for (right = 0; right < nums.length; right++) {
      sum += nums[right];
      while (sum + k < (long) (nums[right] * (right - left + 1))) {
        sum -= nums[left];
        left++;
      }
      ans = Math.max(ans, right - left + 1);
    }

    return ans;
  }
}
