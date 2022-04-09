import java.util.*;

public class First {
  public boolean divideArray(int[] nums) {
    Arrays.sort(nums);
    int index = 0;
    while (index < nums.length) {
      if (nums[index + 1] != nums[index]) {
        return false;
      }
      index += 2;
    }
    return true;
  }
}