import java.util.*;

public class CheckAllIntegersInRange {
  public boolean isCovered(int[][] ranges, int left, int right) {
    Set<Integer> set = new HashSet<>();
    for (int[] range : ranges) {
      for (int i = range[0]; i <= range[1]; i++) {
        set.add(i);
      }
    }
    for (int i = left; i <= right; i++) {
      if (!set.contains(i)) {
        return false;
      }
    }
    return true;
  }
}