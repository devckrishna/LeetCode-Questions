import java.util.*;

public class Permutations2 {
  public void solve(List<List<Integer>> ans, List<Integer> temp, int[] nums, boolean[] visited) {
    if (temp.size() == nums.length)
      ans.add(new ArrayList<Integer>(temp));
    else {
      for (int i = 0; i < nums.length; i++) {
        if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]))
          continue;
        temp.add(nums[i]);
        visited[i] = true;
        solve(ans, temp, nums, visited);
        visited[i] = false;
        temp.remove(temp.size() - 1);
      }
    }
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    solve(ans, new ArrayList<Integer>(), nums, new boolean[nums.length]);
    return ans;
  }
}
