import java.util.HashSet;
import java.util.Set;

public class First {
  public int findFinalValue(int[] nums, int original) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    while (set.contains(original)) {
      original = original * 2;
    }
    return original;
  }
}
