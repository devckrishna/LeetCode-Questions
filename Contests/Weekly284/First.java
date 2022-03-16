import java.util.*;

public class First {
  public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
    List<Integer> ans = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == key) {
        int from = 0;
        int to = 0;
        from = Math.max((i - k), 0);
        to = Math.min((i + k), nums.length - 1);
        for (int j = from; j <= to; j++)
          set.add(j);
      }
    }
    for (int i : set)
      ans.add(i);
    Collections.sort(ans);

    return ans;
  }
}