import java.util.*;

public class First {
  public int[] sortEvenOdd(int[] nums) {
    List<Integer> odd = new ArrayList<>();
    List<Integer> even = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (i % 2 == 0) {
        even.add(nums[i]);
      } else {
        odd.add(nums[i]);
      }
    }
    Collections.sort(even);
    Collections.sort(odd, Collections.reverseOrder());
    int oIndex = 0;
    int eIndex = 0;
    int[] ans = new int[nums.length];
    for (int i = 0; i < ans.length; i++) {
      if (i % 2 == 0) {
        ans[i] = even.get(eIndex++);
      } else {
        ans[i] = odd.get(oIndex++);
      }
    }
    return ans;
  }
}