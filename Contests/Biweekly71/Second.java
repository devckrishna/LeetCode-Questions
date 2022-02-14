import java.util.*;

public class Second {
  public int[] pivotArray(int[] nums, int pivot) {
    List<Integer> arr = new ArrayList<>();
    for (int num : nums) {
      if (num == pivot) {
        arr.add(num);
      }
    }
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    for (int num : nums) {
      if (num == pivot) {
        continue;
      }
      if (num < pivot) {
        left.add(num);
      } else {
        right.add(num);
      }
    }
    int[] ans = new int[nums.length];
    int index = 0;
    for (int num : left) {
      ans[index] = num;
      index++;
    }
    for (int num : arr) {
      ans[index] = num;
      index++;
    }
    for (int num : right) {
      ans[index] = num;
      index++;
    }
    return ans;
  }
}
