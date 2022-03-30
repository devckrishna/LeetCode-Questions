public class First {
  public int[] sortArrayByParity(int[] nums) {
    int[] ans = new int[nums.length];
    int index = 0;
    for (int curr : nums) {
      if (curr % 2 == 0) {
        ans[index++] = curr;
      }
    }
    for (int curr : nums) {
      if (curr % 2 != 0) {
        ans[index++] = curr;
      }
    }
    return ans;
  }
}