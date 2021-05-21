public class MaximalNetwork {
  public int maximalNetworkRank(int n, int[][] roads) {
    boolean[][] isConnected = new boolean[n][n];
    int[] count = new int[1001];
    for (int[] curr : roads) {
      count[curr[0]]++;
      count[curr[1]]++;

      isConnected[curr[0]][curr[1]] = true;
      isConnected[curr[1]][curr[0]] = true;
    }

    int ans = 0;

    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        ans = Math.max(ans, count[i] + count[j] - (isConnected[i][j] ? 1 : 0));
      }
    }
    return ans;
  }
}
