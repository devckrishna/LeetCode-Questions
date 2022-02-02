import java.util.*;

public class LargestPlusSign {
  public int orderOfLargestPlusSign(int n, int[][] mines) {
    int[][] arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(arr[i], 1);
    }
    for (int[] mine : mines) {
      arr[mine[0]][mine[1]] = 0;
    }
    int[][] up = new int[n][n];
    int[][] down = new int[n][n];
    int[][] left = new int[n][n];
    int[][] right = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0) {
          up[i][j] = arr[i][j];
        } else if (arr[i][j] == 1) {
          up[i][j] = 1 + up[i - 1][j];
        }
      }
    }

    for (int i = n - 1; i >= 0; i--) {
      for (int j = 0; j < n; j++) {
        if (i == n - 1) {
          down[i][j] = arr[i][j];
        } else if (arr[i][j] == 1) {
          down[i][j] = 1 + down[i + 1][j];
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (j == 0) {
          left[i][j] = arr[i][j];
        } else if (arr[i][j] == 1) {
          left[i][j] = 1 + left[i][j - 1];
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = n - 1; j >= 0; j--) {
        if (j == n - 1) {
          right[i][j] = arr[i][j];
        } else if (arr[i][j] == 1) {
          right[i][j] = 1 + right[i][j + 1];
        }
      }
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int curr = Math.min(up[i][j], Math.min(down[i][j], Math.min(left[i][j], right[i][j])));
        ans = Math.max(ans, curr);
      }
    }
    return ans;
  }
}
