import java.util.*;

class Permutations {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    solve(nums, ans, new ArrayList<>(), used);
    return ans;

  }

  public static void solve(int[] nums, List<List<Integer>> ans, List<Integer> temp, boolean[] used) {
    if (temp.size() == nums.length) {
      ans.add(new ArrayList<Integer>(temp));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i])
        continue;
      used[i] = true;
      temp.add(nums[i]);
      solve(nums, ans, temp, used);
      temp.remove(temp.size() - 1);
      used[i] = false;
    }

  }
}