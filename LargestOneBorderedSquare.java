public class LargestOneBorderedSquare {
  public int largest1BorderedSquare(int[][] grid) {
    int[][] up = new int[grid.length][grid[0].length];
    int[][] left = new int[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (i == 0) {
          up[i][j] = grid[i][j];
        } else {
          if (grid[i][j] == 1) {
            up[i][j] = up[i - 1][j] + 1;
          }
        }
      }
    }

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (j == 0) {
          left[i][j] = grid[i][j];
        } else {
          if (grid[i][j] == 1) {
            left[i][j] = left[i][j - 1] + 1;
          }
        }
      }
    }
    int ans = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        int curr = Math.min(up[i][j], left[i][j]);
        for (int k = curr; k >= 1; k--) {
          if (up[i][j - k + 1] >= k && left[i - k + 1][j] >= k) {
            ans = Math.max(k * k, ans);
            break;
          }
        }
      }
    }
    return ans;
  }
}
