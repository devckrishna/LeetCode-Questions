import java.util.*;

public class MaxStudentsTakingExam {
  int m, n;
  Map<String, Integer> dp;

  public int maxStudents(char[][] seats) {
    m = seats.length;
    if (m == 0)
      return 0;
    n = seats[0].length;

    dp = new HashMap<String, Integer>();
    StringBuilder sb = new StringBuilder();
    for (char[] row : seats) {
      sb.append(row);
    }

    return dfs(sb.toString());
  }

  public int dfs(String str) {
    if (dp.containsKey(str))
      return dp.get(str);
    int max = 0;
    char[] arr = str.toCharArray();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (arr[i * n + j] == '#') {
          continue;
        }
        arr[i * n + j] = '#';
        max = Math.max(max, dfs(new String(arr)));
        if (j + 1 < n) {
          if (i < m - 1 && arr[(i + 1) * n + j + 1] == '.')
            arr[(i + 1) * n + j + 1] = '#';
          if (arr[i * n + j + 1] == '.')
            arr[i * n + j + 1] = '#';
        }
        if (j - 1 >= 0) {
          if (i < m - 1 && arr[(i + 1) * n + j - 1] == '.')
            arr[(i + 1) * n + j - 1] = '#';
          if (arr[i * n + j - 1] == '.')
            arr[i * n + j - 1] = '#';
        }
        max = Math.max(max, 1 + dfs(new String(arr)));
      }
    }
    dp.put(str, max);
    return max;
  }
}