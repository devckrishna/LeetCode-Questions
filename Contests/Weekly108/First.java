import java.util.*;

public class First {
  public List<Integer> luckyNumbers(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        int ele = matrix[i][j];
        boolean flag = false;
        for (int x = 0; x < matrix.length; x++) {
          if (matrix[x][j] > ele) {
            flag = true;
            break;
          }
        }
        for (int x = 0; x < matrix[0].length; x++) {
          if (matrix[i][x] < ele) {
            flag = true;
            break;
          }
        }
        if (!flag) {
          ans.add(ele);
        }
      }
    }

    return ans;
  }
}