public class ChampagneTower {
  public double champagneTower(int poured, int row, int col) {
    double[][] dp = new double[102][102];
    dp[0][0] = poured * 1.0;
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j <= i; j++) {
        double spare = (dp[i][j] - 1.0) / 2;
        if (spare > 0) {
          dp[i + 1][j] += spare;
          dp[i + 1][j + 1] += spare;
        }

      }
    }
    return dp[row][col];
  }
}
