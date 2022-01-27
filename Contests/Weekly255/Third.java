public class Third {
  public int minimizeTheDifference(int[][] mat, int target) {
    Integer[][] dp = new Integer[mat.length][5001];
    return solve(mat, target, 0, 0, dp);
  }

  public int solve(int[][] arr, int target, int index, int val, Integer[][] dp) {
    if (index == arr.length) {
      return Math.abs(target - val);
    }
    if (dp[index][val] != null) {
      return dp[index][val];
    }
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < arr[0].length; i++) {
      ans = Math.min(ans, solve(arr, target, index + 1, val + arr[index][i], dp));
    }
    return dp[index][val] = ans;
  }
}
