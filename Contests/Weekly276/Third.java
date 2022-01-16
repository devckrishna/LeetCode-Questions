public class Third {
  public long mostPoints(int[][] questions) {
    Long[] dp = new Long[questions.length];
    return solve(questions, 0, dp);
  }

  public long solve(int[][] arr, int index, Long[] dp) {
    if (index >= arr.length) {
      return 0;
    }
    if (dp[index] != null) {
      return dp[index];
    }
    long take = arr[index][0] + solve(arr, index + arr[index][1] + 1, dp);
    long skip = solve(arr, index + 1, dp);
    dp[index] = Math.max(take, skip);
    return dp[index];
  }
}
