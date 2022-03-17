import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToGetFood {
  public int getFood(char[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '*') {
          return solve(grid, i, j);
        }
      }
    }
    return -1;
  }

  public int solve(char[][] grid, int i, int j) {
    Queue<int[]> qu = new LinkedList<>();
    qu.add(new int[] { i, j });
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    visited[i][j] = true;
    int steps = 0;
    while (!qu.isEmpty()) {
      int size = qu.size();
      while (size-- > 0) {
        int[] curr = qu.poll();
        if (grid[curr[0]][curr[1]] == '#') {
          return steps;
        }

        for (int[] dir : dirs) {
          int newi = curr[0] + dir[0];
          int newj = curr[1] + dir[1];
          if (newi >= 0 && newj >= 0 && newi < grid.length && newj < grid[0].length && grid[newi][newj] != 'X'
              && !visited[newi][newj]) {
            visited[newi][newj] = true;
            qu.add(new int[] { newi, newj });
          }
        }
      }
      steps++;
    }

    return -1;
  }
}
