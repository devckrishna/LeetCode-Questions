import java.util.*;

public class TrappingRainWater2 {
  public class Box implements Comparable<Box> {
    int row;
    int col;
    int height;

    public Box(int row, int col, int height) {
      this.row = row;
      this.col = col;
      this.height = height;
    }

    @Override
    public int compareTo(Box o) {
      return this.height - o.height;
    }
  }

  public int trapRainWater(int[][] arr) {
    int n = arr.length;
    int m = arr[0].length;
    PriorityQueue<Box> qu = new PriorityQueue<>();
    boolean[][] visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      visited[i][0] = true;
      visited[i][m - 1] = true;
      qu.add(new Box(i, 0, arr[i][0]));
      qu.add(new Box(i, m - 1, arr[i][m - 1]));
    }

    for (int i = 0; i < m; i++) {
      visited[0][i] = true;
      visited[n - 1][i] = true;
      qu.add(new Box(0, i, arr[0][i]));
      qu.add(new Box(n - 1, i, arr[n - 1][i]));
    }
    int ans = 0;
    while (!qu.isEmpty()) {
      Box temp = qu.poll();
      int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
      for (int[] dir : dirs) {
        int x = temp.row + dir[0];
        int y = temp.col + dir[1];
        if (x >= 0 && y >= 0 && x < n && y < m && !visited[x][y]) {
          visited[x][y] = true;
          ans += Math.max(0, temp.height - arr[x][y]);
          qu.add(new Box(x, y, Math.max(temp.height, arr[x][y])));
        }
      }
    }
    return ans;
  }
}
