public class MinDeletionCostToAvoidRep {
  public int minCost(String s, int[] cost) {
    int ans = 0;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == s.charAt(i - 1)) {
        ans += Math.min(cost[i], cost[i - 1]);
        cost[i] = Math.max(cost[i], cost[i - 1]);
      }
    }

    return ans;
  }
}
