public class MakingALargeIsland {
  int ans = 0;

  public int largestIsland(int[][] grid) {
    boolean[][] visited = new boolean[grid.length][grid.length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        if (grid[i][j] == 0) {
          grid[i][j] = 1;
          dfs(grid, i, j, visited);
          grid[i][j] = 2;
        }
      }
    }

    return ans;
  }

  public int dfs(int[][] grid, int i, int j, boolean[][] visited) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid.length || visited[i][j]) {
      return 0;
    }
    visited[i][j] = true;
    int curr = 0;
    curr += dfs(grid, i + 1, j, visited);
    curr += dfs(grid, i - 1, j, visited);
    curr += dfs(grid, i, j + 1, visited);
    curr += dfs(grid, i, j - 1, visited);
    ans = Math.max(ans, curr + 1);
    return curr + 1;
  }
}
