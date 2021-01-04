import java.util.Arrays;

class FindMissingPositive {
  public int firstMissingPositive(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= 0) {
        nums[i] = nums.length + 1;
      }
    }

    for (int i = 0; i < nums.length; i++) {
      int idx = Math.abs(nums[i]) - 1;
      if (idx + 1 > 0 && idx + 1 <= nums.length) {
        nums[idx] = -Math.abs(nums[idx]);
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= 1) {
        return i + 1;
      }
    }

    return nums.length + 1;
  }

  public int firstMissingPositive2(int[] nums) {
    Arrays.sort(nums);
    int smallest = 1;
    for (int i = 0; i < nums.length; i++) {
      if (smallest == nums[i]) {
        smallest++;
        continue;
      }
    }
    return smallest;
  }
}