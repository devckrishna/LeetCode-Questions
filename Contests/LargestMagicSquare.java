public class LargestMagicSquare {
  public int largestMagicSquare(int[][] grid) {
    int ans = 1;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        int len = 1;
        while (i + len < grid.length && j + len < grid.length) {
          int colSum = 0;
          int rowSum = 0;
          int diaSum = 0;
          for (int row = i; row < len; row++) {
            rowSum += grid[row][j];
          }
          for (int col = i; col < len; col++) {
            colSum += grid[i][col];
          }
          for (int row = i, col = j; row < len && col < len; row++, col++) {
            diaSum += grid[row][col];
          }
          if (rowSum != colSum || rowSum != diaSum) {
            break;
          }
          len++;
        }
        ans = Math.max(ans, len);

      }
    }

    return ans;
  }
}
