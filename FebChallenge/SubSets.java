import java.util.*;

public class SubSets {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    solve(nums, ans, new ArrayList<>(), 0);
    return ans;
  }

  public void solve(int[] nums, List<List<Integer>> ans, List<Integer> temp, int index) {
    if (index == nums.length) {
      if (!ans.contains(temp))
        ans.add(new ArrayList<>(temp));
      return;
    }
    for (int i = index; i < nums.length; i++) {
      solve(nums, ans, temp, i + 1);
      temp.add(nums[i]);
      solve(nums, ans, temp, i + 1);
      temp.remove(temp.size() - 1);
    }
  }
}
