public class Fourth {
  public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
    UnionFind uf = new UnionFind(n, restrictions);
    boolean[] output = new boolean[requests.length];

    for (int i = 0; i < requests.length; ++i) {
      output[i] = uf.union(requests[i][0], requests[i][1]);
    }

    return output;
  }

  class UnionFind {
    int size;
    int[] root, rank;
    int[][] restrictions;

    public UnionFind(int n, int[][] restrictions) {
      size = n;
      root = new int[n];
      rank = new int[n];
      this.restrictions = restrictions;
      for (int i = 0; i < n; ++i) {
        root[i] = i;
        rank[i] = 1;
      }
    }

    private int find(int x) {
      if (x == root[x]) {
        return root[x];
      }

      return find(root[x]);
    }

    public boolean union(int x, int y) {
      int rootX = find(x);
      int rootY = find(y);

      for (int i = 0; i < restrictions.length; ++i) {
        int rootU = find(restrictions[i][0]);
        int rootV = find(restrictions[i][1]);

        if ((rootX == rootU && rootY == rootV) || (rootX == rootV && rootY == rootU)) {
          return false;
        }
      }

      if (rank[rootX] > rank[rootY]) {
        root[rootY] = rootX;
      } else if (rank[rootY] > rank[rootX]) {
        root[rootX] = rootY;
      } else {
        root[rootY] = rootX;
        ++rank[rootX];
      }

      return true;
    }
  }
}
