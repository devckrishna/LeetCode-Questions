import java.util.*;

public class Second {
  public int[] rearrangeArray(int[] nums) {
    List<Integer> positive = new ArrayList<>();
    List<Integer> negetive = new ArrayList<>();
    for (int num : nums) {
      if (num < 0) {
        negetive.add(num);
      } else {
        positive.add(num);
      }
    }
    int[] ans = new int[nums.length];
    int first = 0;
    int second = 0;
    for (int i = 0; i < ans.length; i++) {
      if (i % 2 == 0) {
        ans[i] = positive.get(first++);
      } else {
        ans[i] = negetive.get(second++);
      }
    }
    return ans;
  }
}
