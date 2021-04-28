import java.util.Arrays;

public class MaxIceCreamBar {
  public int maxIceCream(int[] costs, int coins) {
    Arrays.sort(costs);
    int ans = 0;
    if (coins > costs[0]) {
      ans = 1;
      coins -= costs[0];
    }
    int i = 1;
    while (coins > 0 && i < costs.length) {
      coins -= costs[i];
      if (coins < 0) {
        break;
      }
      ans++;
      i++;
    }

    return ans;
  }
}
