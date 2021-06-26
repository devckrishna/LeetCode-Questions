import java.util.Arrays;

public class FindCityWithSmallestNumOfNeiAtThresholdDist {
  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    int[][] graph = new int[n][n];
    for (int[] curr : graph)
      Arrays.fill(curr, 10001);

    for (int i = 0; i < n; i++) {
      graph[i][i] = 0;
    }

    for (int[] edge : edges) {
      graph[edge[0]][edge[1]] = graph[edge[1]][edge[0]] = edge[2];
    }

    int smallest = n;
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
        }
      }
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = 0; j < n; j++) {
        if (graph[i][j] <= distanceThreshold) {
          count++;
        }
      }
      if (count <= smallest) {
        ans = i;
        smallest = count;
      }
    }
    return ans;
  }
}
