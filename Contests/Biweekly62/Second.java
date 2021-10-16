public class Second {
  public int numOfPairs(String[] nums, String target) {
    int ans = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        String curr = nums[i] + nums[j];
        String temp = nums[j] + nums[i];
        if (curr.equals(target)) {
          ans++;
        }
        if (temp.equals(target)) {
          ans++;
        }
      }
    }
    return ans;
  }
}
