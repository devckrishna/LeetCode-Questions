public class HousrRobber {
  public int rob(int[] num) {
    int take = 0;
    int skip = 0;
    for (int n : num) {
      int temp = take;
      take = Math.max(take, skip);
      skip = n + temp;
    }
    return Math.max(take, skip);
  }
}
