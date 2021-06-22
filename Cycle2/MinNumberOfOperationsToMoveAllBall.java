import java.util.*;

public class MinNumberOfOperationsToMoveAllBall {
  public int[] minOperations(String boxes) {
    List<Integer> points = new ArrayList<>();
    int i = 0;
    for (char ch : boxes.toCharArray()) {
      if (ch == '1') {
        points.add(i);
      }
      i++;
    }
    int[] ans = new int[boxes.length()];
    for (int x = 0; x < ans.length; x++) {
      int temp = 0;
      for (Integer point : points) {
        temp += Math.abs(point - x);
      }
      ans[x] = temp;
    }
    return ans;
  }
}
