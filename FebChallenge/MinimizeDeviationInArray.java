import java.util.TreeSet;

public class MinimizeDeviationInArray {
  public int minimumDeviation(int[] nums) {
    TreeSet<Integer> set = new TreeSet<>();
    for (int num : nums) {
      if (num % 2 == 0) {
        set.add(num);
      } else {
        set.add(num * 2);
      }
    }
    int ans = Integer.MAX_VALUE;
    while (true) {
      int curr = set.last();
      ans = Math.min(ans, curr - set.first());
      if (curr % 2 == 0) {
        set.remove(curr);
        set.add(curr / 2);
      } else {
        break;
      }
    }
    return ans;
  }
}
