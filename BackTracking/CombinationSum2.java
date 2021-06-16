import java.util.*;

public class CombinationSum2 {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ans = new ArrayList<>();
    solve(1, n, k, ans, new ArrayList<>());
    return ans;
  }

  private void solve(int index, int n, int k, List<List<Integer>> ans, List<Integer> temp) {
    if (n == 0) {
      if (k == 0)
        ans.add(new ArrayList<>(temp));
      return;
    }
    if (k == 0) {
      return;
    }
    for (int i = index; i <= 9; i++) {
      temp.add(i);
      solve(i + 1, n - i, k - 1, ans, temp);
      temp.remove(temp.size() - 1);
    }
  }
}
