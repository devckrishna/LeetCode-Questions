public class CountFertilePyramidsInLand {
  public int countPyramids(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 0) {
          count = 0;
        } else {
          count++;
        }
        grid[i][j] = count;
      }
      count = 0;
      for (int j = m - 1; j >= 0; j--) {
        if (grid[i][j] == 0) {
          count = 0;
        } else {
          count++;
        }
        grid[i][j] = Math.min(grid[i][j], count);
      }
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 0)
          continue;
        int index = 0;
        while (index + i < n && grid[index + i][j] > index)
          index++;
        ans += index - 1;

        index = 0;
        while (i - index >= 0 && grid[i - index][j] > index)
          index++;
        ans += index - 1;
      }
    }

    return ans;
  }
}
