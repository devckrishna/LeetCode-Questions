import java.util.*;

public class SequentialDigits {
  public List<Integer> sequentialDigits(int low, int high) {
    List<Integer> ans = new ArrayList<>();
    for (int i = 1; i <= 9; i++) {
      solve(0, i, low, high, ans);
    }
    Collections.sort(ans);
    return ans;
  }

  public void solve(int cur, int nums, int low, int high, List<Integer> ans) {
    cur = cur * 10 + nums;
    if (cur > high)
      return;

    if (cur >= low) {
      ans.add(cur);
    }

    if (nums + 1 <= 9)
      solve(cur, nums + 1, low, high, ans);
  }
}
