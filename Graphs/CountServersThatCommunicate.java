public class CountServersThatCommunicate {
  public int countServers(int[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          int curr = dfs(grid, i, j);
          count += curr > 1 ? curr : 0;
        }
      }
    }

    return count;
  }

  public int dfs(int[][] grid, int i, int j) {
    int ans = 1;
    grid[i][j] = 0;
    for (int x = 0; x < grid.length; x++) {
      if (grid[x][j] == 1) {
        ans += dfs(grid, x, j);
      }
    }

    for (int x = 0; x < grid[0].length; x++) {
      if (grid[i][x] == 1) {
        ans += dfs(grid, i, x);
      }
    }

    return ans;
  }
}
