public class CherryPickup2 {
  public int solve(int[][] grid, int row, int col1, int col2, Integer[][][] dp) {
    if (row >= grid.length || col1 < 0 || col2 < 0 || col1 >= grid[0].length || col2 >= grid[0].length) {
      return 0;
    }
    if (dp[row][col1][col2] != null) {
      return dp[row][col1][col2];
    }
    int ans = grid[row][col1];
    if (col1 != col2) {
      ans += grid[row][col2];
    }
    if (row != grid.length - 1) {
      int max = 0;
      for (int i = col1 - 1; i <= col1 + 1; i++) {
        for (int j = col2 - 1; j <= col2 + 1; j++) {
          max = Math.max(max, solve(grid, row + 1, i, j, dp));
        }
      }
      ans += max;
    }

    dp[row][col1][col2] = ans;
    return ans;
  }

  public int cherryPickup(int[][] grid) {
    Integer[][][] dp = new Integer[grid.length][grid[0].length][grid[0].length];
    return solve(grid, 0, 0, grid[0].length - 1, dp);
  }
}
