public class JumpGameI {
  public boolean canJump(int[] nums) {
    boolean[] dp = new boolean[nums.length];
    dp[dp.length - 1] = true;
    for (int i = dp.length - 2; i >= 0; i--) {
      int jumps = nums[i];
      for (int j = 0; j <= jumps; j++) {
        if (i + j < dp.length && dp[i + j]) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[0];
  }
}
