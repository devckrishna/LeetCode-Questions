public class CherryPickup2 {
  public int cherryPickup(int[][] grid) {
    Integer[][][] dp = new Integer[grid.length][grid[0].length][grid[0].length];
    return solve(0, 0, grid[0].length - 1, grid, dp);
  }

  public int solve(int row, int col1, int col2, int[][] grid, Integer[][][] dp) {
    if (row < 0 || col1 < 0 || col2 < 0 || col1 >= grid[0].length || col2 >= grid[0].length) {
      return 0;
    }
    if (dp[row][col1][col2] != null) {
      return dp[row][col1][col2];
    }
    int result = 0;
    result += grid[row][col1];
    if (col1 != col2) {
      result += grid[row][col2];
    }
    if (row != grid.length - 1) {
      int max = 0;
      for (int newCol1 = col1 - 1; newCol1 <= col1 + 1; newCol1++) {
        for (int newCol2 = col2 - 1; newCol2 <= col2 + 1; newCol2++) {
          max = Math.max(max, solve(row + 1, newCol1, newCol2, grid, dp));
        }
      }
      result += max;
    }

    dp[row][col1][col2] = result;
    return result;
  }
}