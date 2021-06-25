import java.util.*;

public class ShortestBridge {
  int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

  public void dfs(int[][] grid, int i, int j, Queue<int[]> qu) {
    grid[i][j] = 2;
    qu.add(new int[] { i, j, 0 });
    for (int[] dir : dirs) {
      int x = i + dir[0];
      int y = j + dir[1];
      if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1) {
        dfs(grid, x, y, qu);
      }
    }
  }

  public int shortestBridge(int[][] grid) {
    Queue<int[]> qu = new LinkedList<>();
    boolean flag = false;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (!flag && grid[i][j] == 1) {
          dfs(grid, i, j, qu);
          flag = true;
        }
      }
    }

    while (!qu.isEmpty()) {
      int[] temp = qu.poll();
      int i = temp[0];
      int j = temp[1];
      int level = temp[2];
      for (int[] dir : dirs) {
        int x = i + dir[0];
        int y = j + dir[1];
        if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] != 2) {
          if (grid[x][y] == 1) {
            return level;
          }
          grid[x][y] = 2;
          qu.add(new int[] { x, y, level + 1 });
        }
      }
    }
    return -1;
  }
}
