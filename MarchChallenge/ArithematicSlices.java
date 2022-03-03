public class ArithematicSlices {
  public int numberOfArithmeticSlices(int[] arr) {
    if (arr.length < 3) {
      return 0;
    }
    int[] dp = new int[arr.length];
    for (int i = 2; i < dp.length; i++) {
      if (arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]) {
        dp[i] = dp[i - 1] + 1;
      }
    }
    int ans = 0;
    for (int i = 0; i < dp.length; i++) {
      ans += dp[i];
    }
    return ans;
  }
}
