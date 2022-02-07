public class UniquePath3 {
  int ans = 0, count = 1, sx, sy, ex, ey;

  public int uniquePathsIII(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (grid[i][j] == 0)
          count++;
        else if (grid[i][j] == 1) {
          sx = i;
          sy = j;
        }
      }
    }
    solve(grid, sx, sy);
    return ans;
  }

  public void solve(int[][] grid, int x, int y) {
    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0)
      return;
    if (grid[x][y] == 2) {
      if (count == 0)
        ans++;
      return;
    }
    grid[x][y] = -2;
    count--;
    solve(grid, x + 1, y);
    solve(grid, x - 1, y);
    solve(grid, x, y + 1);
    solve(grid, x, y - 1);
    grid[x][y] = 0;
    count++;
  }
}
