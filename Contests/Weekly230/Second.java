public class Second {
  int ans;

  public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
    ans = baseCosts[0];
    for (int base : baseCosts) {
      solve(base, toppingCosts, target, 0);
    }
    return ans;
  }

  public void solve(int curr, int[] arr, int target, int index) {
    if (Math.abs(curr - target) < Math.abs(ans - target)) {
      ans = curr;
    } else if (Math.abs(curr - target) == Math.abs(ans - target)) {
      ans = Math.min(ans, curr);
    }
    if (index == arr.length) {
      return;
    }
    solve(curr, arr, target, index + 1);
    solve(curr + arr[index], arr, target, index + 1);
    solve(curr + 2 * arr[index], arr, target, index + 1);
  }
}
