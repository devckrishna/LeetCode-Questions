import java.util.*;

public class SequentialDigits {
  public List<Integer> sequentialDigits(int low, int high) {
    List<Integer> res = new ArrayList<>();
    for (int i = 1; i <= 9; i++) {
      solve(0, i, low, high, res);
    }
    Collections.sort(res);
    return res;
  }

  public void solve(int cur, int nums, int low, int high, List<Integer> res) {
    cur = cur * 10 + nums;
    if (cur > high)
      return;

    if (cur >= low) {
      res.add(cur);
    }

    if (nums + 1 <= 9)
      solve(cur, nums + 1, low, high, res);
  }
}
