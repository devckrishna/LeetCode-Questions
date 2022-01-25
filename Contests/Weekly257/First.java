public class First {
  public int countQuadruplets(int[] nums) {
    int ans = 0;
    for (int i = 0; i < nums.length - 3; i++) {
      for (int j = i + 1; j < nums.length - 2; j++) {
        for (int k = j + 1; k < nums.length - 1; k++) {
          for (int x = k + 1; x < nums.length; x++) {
            if (nums[i] + nums[j] + nums[k] == nums[x]) {
              ans++;
            }
          }
        }
      }
    }
    return ans;
  }
}