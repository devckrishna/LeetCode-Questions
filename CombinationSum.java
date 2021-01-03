import java.util.*;

class CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(candidates);
    solve(candidates, 0, target, ans, new ArrayList<Integer>());
    return ans;
  }

  public static void solve(int[] candidates, int start, int target, List<List<Integer>> ans, List<Integer> temp) {
    if (target == 0) {
      ans.add(new ArrayList<Integer>(temp));
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      target -= candidates[i];
      if (target < 0) {
        break;
      }
      temp.add(candidates[i]);
      solve(candidates, i, target, ans, temp);
      temp.remove(temp.size() - 1);
      target += candidates[i];
    }

  }
}
