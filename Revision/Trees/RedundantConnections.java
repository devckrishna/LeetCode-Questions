public class RedundantConnections {

  public int[] findRedundantConnection(int[][] edges) {
    int[] parent = new int[2001];
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
    }
    for (int[] edge : edges) {
      int first = edge[0];
      int second = edge[1];
      if (findParent(parent, first) == findParent(parent, second)) {
        return edge;
      } else {
        parent[findParent(parent, first)] = findParent(parent, second);
      }
    }

    return new int[2];
  }

  public int findParent(int[] parent, int x) {
    if (parent[x] != x) {
      parent[x] = findParent(parent, parent[x]);
    }
    return parent[x];
  }
}
