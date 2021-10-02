public class Second {
  public long gridGame(int[][] grid) {
    int n = grid[0].length;
    long[] left = new long[n + 2];
    long[] right = new long[n + 2];
    for (int i = n; i >= 1; i--) {
      left[i] = left[i + 1] + grid[0][i - 1];
    }
    for (int i = 1; i <= n; i++) {
      right[i] = right[i - 1] + grid[1][i - 1];
    }
    long res = Long.MAX_VALUE;
    for (int i = 1; i <= n; i++) {
      res = Math.min(Math.max(left[i + 1], right[i - 1]), res);
    }

    return res;
  }
}
