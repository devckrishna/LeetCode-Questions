import java.util.*;

class AllSubsets {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    solve(nums, 0, ans, new ArrayList<>());
    return ans;
  }

  public static void solve(int[] nums, int start, List<List<Integer>> ans, List<Integer> temp) {
    if (start == nums.length) {
      ans.add(new ArrayList<>(temp));
      return;
    }
    temp.add(nums[start]);
    solve(nums, start + 1, ans, temp);
    temp.remove(temp.size() - 1);
    solve(nums, start + 1, ans, temp);

  }
}