public class MinScoreTriangluation {
  public int minScoreTriangulation(int[] A) {
    int[][] dp = new int[A.length][A.length];

    for (int g = 0; g < dp.length; g++) {
      for (int i = 0, j = g; j < dp[0].length; i++, j++) {
        if (g == 0) {
          dp[i][j] = 0;
        } else if (g == 1) {
          dp[i][j] = 0;
        } else if (g == 2) {
          dp[i][j] = A[i] * A[i + 1] * A[i + 2];
        } else {
          int min = Integer.MAX_VALUE;
          for (int k = i + 1; k < j; k++) {
            int tri = A[i] * A[j] * A[k];
            int left = dp[i][k];
            int right = dp[k][j];

            int total = tri + left + right;
            if (total < min) {
              min = total;
            }
          }
          dp[i][j] = min;
        }
      }
    }

    return dp[0][A.length - 1];
  }
}
