import java.util.*;

public class Second {
  public List<Integer> goodDaysToRobBank(int[] security, int time) {
    int[] left = new int[security.length];
    int[] right = new int[security.length];

    left[0] = 1;
    for (int i = 1; i < left.length; i++) {
      left[i] = security[i - 1] >= security[i] ? left[i - 1] + 1 : 1;
    }
    right[right.length - 1] = 1;
    for (int i = right.length - 2; i >= 0; i--) {
      right[i] = security[i + 1] >= security[i] ? right[i + 1] + 1 : 1;
    }

    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < security.length; i++) {
      if (left[i] > time && right[i] > time) {
        ans.add(i);
      }
    }
    return ans;
  }
}
