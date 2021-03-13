public class UniquePaths2 {
  public static int solve(int[][] arr, int i, int j, int[][] dp) {
    if (i >= arr.length || j >= arr[0].length || arr[i][j] == 1) {
      return 0;
    }
    if (i == arr.length - 1 && j == arr[0].length - 1) {
      return 1;
    }
    if (dp[i][j] != 0) {
      return dp[i][j];
    }
    int count = 0;
    count += solve(arr, i + 1, j, dp);
    count += solve(arr, i, j + 1, dp);
    dp[i][j] = count;
    return count;
  }

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
    return solve(obstacleGrid, 0, 0, dp);
  }
}
