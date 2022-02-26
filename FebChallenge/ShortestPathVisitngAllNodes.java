import java.util.*;

public class ShortestPathVisitngAllNodes {
  public int shortestPathLength(int[][] graph) {
    int n = graph.length;
    int target = (1 << n) - 1;
    Queue<int[]> qu = new LinkedList<>();
    boolean[][] dp = new boolean[graph.length][1 << n];
    for (int i = 0; i < n; i++) {
      qu.add(new int[] { i, (1 << i) });
    }
    int steps = 0;
    while (!qu.isEmpty()) {
      int size = qu.size();
      while (size-- > 0) {
        int[] curr = qu.poll();
        int node = curr[0];
        int state = curr[1];
        if (state == target) {
          return steps;
        }
        if (dp[node][state]) {
          continue;
        }
        dp[node][state] = true;
        for (int nei : graph[node]) {
          qu.add(new int[] { nei, state | (1 << nei) });
        }
      }
      steps++;
    }
    return steps;
  }
}
