import java.util.*;

public class AsFarLandAsPossible {
  public int maxDistance(int[][] grid) {
    Queue<int[]> qu = new LinkedList<>();
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (!visited[i][j] && grid[i][j] == 1) {
          visited[i][j] = true;
          qu.offer(new int[] { i, j });
        }
      }
    }

    int result = -1;
    while (!qu.isEmpty()) {
      int size = qu.size();
      while (size-- > 0) {
        int[] curr = qu.poll();
        result = Math.max(result, grid[curr[0]][curr[1]] - 1);
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int[] dir : dirs) {
          int x = curr[0] + dir[0];
          int y = curr[1] + dir[1];
          if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && !visited[x][y]) {
            visited[x][y] = true;
            grid[x][y] = grid[curr[0]][curr[1]] + 1;
            qu.offer(new int[] { x, y });
          }
        }
      }
    }

    return result == 0 ? -1 : result;
  }
}
