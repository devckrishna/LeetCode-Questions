import java.util.*;

public class SplitArrayIntoFibo {
  public List<Integer> splitIntoFibonacci(String num) {
    List<Integer> ans = new ArrayList<>();
    if (solve(num, 0, ans)) {
      return ans;
    } else {
      return new ArrayList<>();
    }
  }

  private boolean solve(String nums, int index, List<Integer> ans) {
    if (index == nums.length()) {
      return ans.size() > 2;
    }
    int n = 0;
    for (int i = index; i < nums.length(); i++) {

      n = n * 10 + (nums.charAt(i) - '0');
      if (n < 0) {
        return false;
      }
      if (ans.size() < 2 || ans.get(ans.size() - 2) + ans.get(ans.size() - 1) == n) {
        ans.add(n);
        if (solve(nums, i + 1, ans)) {
          return true;
        }
        ans.remove(ans.size() - 1);
        if (i == index && nums.charAt(i) == '0')
          return false;
      }
    }
    return false;
  }
}
