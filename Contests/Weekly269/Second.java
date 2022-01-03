import java.util.*;

public class Second {
  public int[] getAverages(int[] nums, int k) {
    if (k == 0)
      return nums;
    long[] sum = new long[nums.length];
    sum[0] = nums[0];

    for (int i = 1; i < nums.length; i++)
      sum[i] = sum[i - 1] + nums[i];

    int[] ans = new int[nums.length];
    Arrays.fill(ans, -1);

    for (int i = k; i < nums.length - k; i++) {
      long temp = (sum[i + k] - sum[i - k] + nums[i - k]) / (k * 2 + 1);
      ans[i] = (int) temp;
    }
    return ans;
  }
}
