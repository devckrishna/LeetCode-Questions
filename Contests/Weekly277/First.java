public class First {
  public int countElements(int[] nums) {
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
      boolean first = false;
      boolean second = false;
      for (int j = 0; j < nums.length; j++) {
        if (nums[j] > nums[i]) {
          first = true;
        }
        if (nums[j] < nums[i]) {
          second = true;
        }
      }
      if (first && second) {
        ans++;
      }
    }
    return ans;
  }
}