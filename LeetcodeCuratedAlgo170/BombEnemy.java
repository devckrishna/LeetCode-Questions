public class BombEnemy {
  public int maxKilledEnemies(char[][] grid) {
    if (grid.length == 0)
      return 0;

    int rows = grid.length;
    int cols = grid[0].length;

    int ans = 0;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == '0') {
          int curr = solve(i, j, grid);
          ans = Math.max(ans, curr);
        }
      }
    }

    return ans;
  }

  public int solve(int row, int col, char[][] grid) {
    int count = 0;
    for (int c = col - 1; c >= 0; --c) {
      if (grid[row][c] == 'W')
        break;
      else if (grid[row][c] == 'E')
        count += 1;
    }

    for (int c = col + 1; c < grid[0].length; ++c) {
      if (grid[row][c] == 'W')
        break;
      else if (grid[row][c] == 'E')
        count += 1;
    }
    for (int r = row - 1; r >= 0; --r) {
      if (grid[r][col] == 'W')
        break;
      else if (grid[r][col] == 'E')
        count += 1;
    }
    for (int r = row + 1; r < grid.length; ++r) {
      if (grid[r][col] == 'W')
        break;
      else if (grid[r][col] == 'E')
        count += 1;
    }

    return count;
  }
}
