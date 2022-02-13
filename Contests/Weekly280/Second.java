import java.util.*;

public class Second {
  public int minimumOperations(int[] nums) {
    Map<Integer, Integer> odd = new HashMap<>();
    Map<Integer, Integer> even = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (i % 2 == 0)
        even.put(nums[i], even.getOrDefault(nums[i], 0) + 1);
      else
        odd.put(nums[i], odd.getOrDefault(nums[i], 0) + 1);
    }
    for (int key : odd.keySet()) {
      if (even.getOrDefault(key, 0) != 0) {
        if (even.get(key) > odd.get(key))
          odd.put(key, 0);
        else
          even.put(key, 0);
      }
    }
    int oddNum = 0;
    int evenNum = 0;
    for (int key : odd.keySet())
      oddNum = Math.max(oddNum, odd.get(key));
    for (int key : even.keySet())
      evenNum = Math.max(evenNum, even.get(key));
    return nums.length - oddNum - evenNum;
  }
}
