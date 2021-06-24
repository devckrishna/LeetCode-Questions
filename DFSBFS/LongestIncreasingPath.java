public class LongestIncreasingPath {
  public static final int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

  public int longestIncreasingPath(int[][] matrix) {
    Integer[][] dp = new Integer[matrix.length][matrix[0].length];
    int max = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        max = Math.max(max, dfs(matrix, i, j, dp));
      }
    }
    return max;
  }

  public int dfs(int[][] grid, int i, int j, Integer[][] dp) {
    if (dp[i][j] != null) {
      return dp[i][j];
    }
    int max = 1;
    for (int[] dir : dirs) {
      int x = i + dir[0];
      int y = j + dir[1];
      if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[i][j] >= grid[x][y]) {
        continue;
      }
      int len = dfs(grid, x, y, dp) + 1;
      max = Math.max(max, len);
    }
    dp[i][j] = max;
    return max;
  }
}
