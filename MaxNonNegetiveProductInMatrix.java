public class MaxNonNegetiveProductInMatrix {
  public int maxProductPath(int[][] grid) {
    int mod = 1000000007;
    long[][] max = new long[grid.length][grid[0].length];
    long[][] min = new long[grid.length][grid[0].length];
    for (int i = grid.length - 1; i >= 0; i--) {
      for (int j = grid[0].length - 1; j >= 0; j--) {
        int val = grid[i][j];
        if (i == grid.length - 1 && j == grid[0].length - 1) {
          max[i][j] = val;
          min[i][j] = val;
        } else if (i == grid.length - 1) {
          max[i][j] = max[i][j + 1] * val;
          min[i][j] = min[i][j + 1] * val;
        } else if (j == grid[0].length - 1) {
          max[i][j] = max[i + 1][j] * val;
          min[i][j] = min[i + 1][j] * val;
        } else {
          max[i][j] = Math.max(Math.max(max[i + 1][j] * val, max[i][j + 1] * val),
              Math.max(min[i + 1][j] * val, min[i][j + 1] * val));
          min[i][j] = Math.min(Math.min(min[i + 1][j] * val, min[i][j + 1] * val),
              Math.min(max[i + 1][j] * val, max[i][j + 1] * val));
        }
      }
    }

    return max[0][0] < 0 ? -1 : (int) (max[0][0] % mod);
  }
}
