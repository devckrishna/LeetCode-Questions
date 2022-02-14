public class SpitArrayWithSameAverage {
  Boolean dp[][];

  public boolean splitArraySameAverage(int[] A) {
    int sum = 0;
    int n = A.length;
    for (int i = 0; i < A.length; i++) {
      sum += A[i];
    }
    dp = new Boolean[sum + 1][n + 1];
    return solve(A, sum, n, 0, 0, 0);
  }

  public boolean solve(int[] a, int sum, int count, int currSum, int currCount, int index) {
    if (dp[currSum][currCount] != null)
      return dp[currSum][currCount];
    if (index == a.length) {
      double secondav = (sum - currSum) / ((count - currCount) * 1.0);
      return (currSum / (currCount * 1.0) == secondav);
    }

    boolean ans = solve(a, sum, count, currSum + a[index], currCount + 1, index + 1) ||
        solve(a, sum, count, currSum, currCount, index + 1);
    dp[currSum][currCount] = ans;
    return ans;
  }
}
