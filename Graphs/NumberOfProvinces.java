public class NumberOfProvinces {
  public void dfs(int[][] isConnected, boolean[] visited, int src) {

    for (int i = 0; i < isConnected.length; i++) {
      if (!visited[i] && isConnected[src][i] == 1) {
        visited[i] = true;
        dfs(isConnected, visited, i);
      }
    }
  }

  public int findCircleNum(int[][] isConnected) {
    boolean[] visited = new boolean[isConnected.length];
    int count = 0;
    for (int i = 0; i < isConnected.length; i++) {
      if (!visited[i]) {
        dfs(isConnected, visited, i);
        count++;
      }
    }

    return count;
  }
}
