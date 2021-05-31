public class BurstBallon {
  public int maxCoins(int[] nums) {
    int[] arr = new int[nums.length + 2];
    int n = 1;
    for (int num : nums) {
      if (num > 0) {
        arr[n++] = num;
      }
    }
    arr[0] = arr[n++] = 1;
    Integer[][] dp = new Integer[n][n];
    return solve(arr, 0, n - 1, dp);
  }

  public int solve(int[] arr, int left, int right, Integer[][] dp) {
    if (left + 1 == right) {
      return 0;
    }
    if (dp[left][right] != null) {
      return dp[left][right];
    }
    int ans = 0;
    for (int i = left + 1; i < right; i++) {
      ans = Math.max(ans, arr[left] * arr[i] * arr[right] + solve(arr, left, i, dp) + solve(arr, i, right, dp));
    }
    dp[left][right] = ans;
    return ans;
  }
}
