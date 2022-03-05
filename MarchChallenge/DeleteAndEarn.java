public class DeleteAndEarn {
  public int deleteAndEarn(int[] nums) {
    int[] dp = new int[10001];
    for (int num : nums) {
      dp[num] += num;
    }
    int take = 0;
    int skip = 0;
    for (int num : dp) {
      int temp = take;
      take = Math.max(take, skip + num);
      skip = temp;
    }
    return Math.max(take, skip);
  }
}
