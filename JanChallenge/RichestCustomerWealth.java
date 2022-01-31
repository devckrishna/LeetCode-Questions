public class RichestCustomerWealth {
  public int maximumWealth(int[][] accounts) {
    int ans = 0;
    for (int[] curr : accounts) {
      int max = 0;
      for (int temp : curr) {
        max += temp;
      }
      ans = Math.max(ans, max);
    }
    return ans;
  }
}
