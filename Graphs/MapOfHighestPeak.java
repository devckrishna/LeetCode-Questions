import java.util.*;

public class MapOfHighestPeak {
  public int[][] highestPeak(int[][] isWater) {
    int[][] mat = new int[isWater.length][isWater[0].length];
    Queue<int[]> qu = new LinkedList<>();
    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    for (int i = 0; i < mat.length; i++) {
      Arrays.fill(mat[i], -1);
      for (int j = 0; j < mat[0].length; j++) {
        if (isWater[i][j] == 1) {
          mat[i][j] = 0;
          qu.add(new int[] { i, j });
        }
      }
    }

    while (!qu.isEmpty()) {
      int[] curr = qu.remove();
      for (int[] dir : dirs) {
        int x = curr[0] + dir[0];
        int y = curr[1] + dir[1];
        if (x < 0 || y < 0 || x >= isWater.length || y >= isWater[0].length || mat[x][y] != -1)
          continue;
        mat[x][y] = mat[curr[0]][curr[1]] + 1;
        qu.add(new int[] { x, y });
      }
    }
    return mat;
  }
}
