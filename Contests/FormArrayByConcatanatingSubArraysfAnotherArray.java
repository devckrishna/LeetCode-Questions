public class FormArrayByConcatanatingSubArraysfAnotherArray {
  public boolean canChoose(int[][] groups, int[] nums) {
    return solve(groups, nums, 0, 0);
  }

  public boolean solve(int[][] groups, int[] nums, int index, int count) {
    if (count == groups.length) {
      return true;
    }
    if (index >= nums.length) {
      return false;
    }
    int[] temp = groups[count];
    for (int i = index; i < nums.length; i++) {
      if (nums[i] == temp[0]) {
        int curr = i;
        boolean found = true;
        for (int t : temp) {
          if (curr >= nums.length) {
            found = false;
            break;
          }
          if (t != nums[curr]) {
            found = false;
            break;
          }
          curr++;
        }
        if (found) {
          i = curr;
          return solve(groups, nums, i, count + 1);
        }
      }
    }
    return false;
  }
}
