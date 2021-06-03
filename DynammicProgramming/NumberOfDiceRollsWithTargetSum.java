public class NumberOfDiceRollsWithTargetSum {
  int[][] memo;
  int M = (int) Math.pow(10, 9) + 7;

  public int numRollsToTarget(int d, int f, int target) {

    memo = new int[d + 1][target + 1];

    return dfs(d, f, target, 0);
  }

  public int dfs(int d, int f, int target, int sum) {

    if (sum + d > target || sum + d * f < target)
      return 0;

    if (memo[d][sum] != 0)
      return memo[d][sum];

    if (d == 0) {
      if (sum == target)
        return 1;
      else
        return 0;
    }

    int res = 0;

    for (int i = 1; i <= f; i++) {
      if (d > 0 && sum + i > target)
        continue;
      if (sum + i > target)
        continue;
      int poss = dfs(d - 1, f, target, sum + i);
      res = (res % M + poss % M) % M;
    }

    memo[d][sum] = res;

    return res;
  }
}
