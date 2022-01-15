public class JumpGameV {
  public int maxJumps(int[] arr, int d) {
    Integer[] dp = new Integer[arr.length];
    int ans = 0;
    for (int i = 0; i < arr.length; i++) {
      ans = Math.max(ans, 1 + solve(arr, i, d, dp));
    }

    return ans;
  }

  public int solve(int[] arr, int index, int d, Integer[] dp) {
    if (index < 0 || index >= arr.length) {
      return 0;
    }
    if (dp[index] != null) {
      return dp[index];
    }
    int forward = 0;
    int backward = 0;

    for (int i = 1; i <= d; i++) {
      if (index + i < arr.length || arr[index] <= arr[index + i]) {
        break;
      }
      forward = Math.max(forward, 1 + solve(arr, index + i, d, dp));
    }

    for (int i = 1; i <= d; i++) {
      if (index - i < arr.length || arr[index] <= arr[index - i]) {
        break;
      }
      backward = Math.max(backward, 1 + solve(arr, index - i, d, dp));
    }
    dp[index] = Math.max(forward, backward);
    return dp[index];
  }
}
