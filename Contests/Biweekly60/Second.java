import java.util.ArrayList;
import java.util.*;

public class Second {
  public int[][] findFarmland(int[][] land) {
    List<int[]> curr = new ArrayList<>();
    for (int i = 0; i < land.length; i++) {
      for (int j = 0; j < land[0].length; j++) {
        if (land[i][j] == 1) {
          int[] second = bfs(land, i, j);
          curr.add(new int[] { i, j, second[0], second[1] });
        }
      }
    }
    int[][] ans = new int[curr.size()][4];
    for (int i = 0; i < ans.length; i++) {
      ans[i] = curr.get(i);
    }
    return ans;
  }

  public int[] bfs(int[][] arr, int i, int j) {
    Queue<int[]> qu = new LinkedList<>();
    int[] ans = new int[2];
    qu.add(new int[] { i, j });
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    while (!qu.isEmpty()) {
      int size = qu.size();
      while (size-- > 0) {
        int[] temp = qu.remove();
        ans = temp;
        // System.out.println("-------");
        // for (int w = 0; w < temp.length; w++) {
        // System.out.print(temp[w] + " ");
        // }
        for (int[] dir : dirs) {
          int x = temp[0] + dir[0];
          int y = temp[1] + dir[1];
          if (x >= 0 && y >= 0 && x < arr.length && y < arr[0].length && arr[x][y] == 1) {
            qu.add(new int[] { x, y });
            arr[x][y] = 0;
            arr[i][j] = 0;
          }
        }
      }
    }
    return ans;
  }
}
