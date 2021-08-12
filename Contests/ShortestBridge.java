import java.util.*;

public class ShortestBridge {
  static int[][] dirs = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

  public int shortestBridge(int[][] grid) {
    Queue<int[]> qu = new LinkedList<>();
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    boolean found = false;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (found) {
          break;
        }
        if (grid[i][j] == 1) {
          dfs(grid, i, j, qu, visited);
          found = true;
          break;
        }
      }
    }

    int steps = 0;
    while (!qu.isEmpty()) {
      int size = qu.size();
      while (size-- > 0) {
        int[] pos = qu.poll();
        for (int[] dir : dirs) {
          int x = pos[0] + dir[0];
          int y = pos[1] + dir[1];
          if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && !visited[x][y]) {
            if (grid[x][y] == 1) {
              return steps;
            }
            qu.add(new int[] { x, y });
            visited[x][y] = true;
          }
        }
      }
      steps++;
    }

    return -1;
  }

  public void dfs(int[][] grid, int i, int j, Queue<int[]> qu, boolean[][] visited) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
      return;
    }
    visited[i][j] = true;
    qu.offer(new int[] { i, j });
    for (int[] dir : dirs) {
      int x = i + dir[0];
      int y = j + dir[1];
      dfs(grid, x, y, qu, visited);
    }
  }
}
