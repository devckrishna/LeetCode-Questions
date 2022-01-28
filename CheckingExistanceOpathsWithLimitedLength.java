import java.util.Arrays;

public class CheckingExistanceOpathsWithLimitedLength {
  int index = 0;
  int[] parent;

  public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
    boolean[] ans = new boolean[queries.length];
    Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
    int[][] curr = new int[queries.length][4];
    parent = new int[n];
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
    }
    for (int i = 0; i < curr.length; i++) {
      int[] q = queries[i];
      curr[i] = new int[] { q[0], q[1], q[2], i };
    }
    Arrays.sort(curr, (a, b) -> a[2] - b[2]);
    for (int[] temp : curr) {
      ans[temp[3]] = solve(edgeList, temp[0], temp[1], temp[2]);
    }
    return ans;
  }

  public boolean solve(int[][] edges, int start, int end, int limit) {
    for (int i = index; i < edges.length; i++) {
      if (edges[i][2] >= limit) {
        index = i;
        break;
      }
      int first = find(edges[i][0]);
      int second = find(edges[i][1]);
      if (first != second) {
        parent[first] = parent[second];
      }
    }

    return find(start) == find(end);
  }

  public int find(int x) {
    if (parent[x] == x) {
      return parent[x];
    }
    parent[x] = find(parent[x]);
    return parent[x];
  }
}
