import java.util.*;

public class MatchSticksToSquare {
  Map<String, Boolean> dp = new HashMap<>();

  public void reverse(int[] nums) {
    int i = 0, j = nums.length - 1;
    while (i < j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
      i++;
      j--;
    }
  }

  public boolean makesquare(int[] matchsticks) {
    int sum = 0;
    for (int m : matchsticks) {
      sum += m;
    }
    if (sum % 4 != 0) {
      return false;
    }
    sum /= 4;
    Arrays.sort(matchsticks);
    reverse(matchsticks);
    return solve(matchsticks, sum, sum, sum, sum, 0);
  }

  public boolean solve(int[] arr, int first, int second, int third, int fourth, int index) {
    if (first < 0 || second < 0 || third < 0 || fourth < 0 || index > arr.length) {
      return false;
    }
    if (index == arr.length) {
      if (first == 0 && second == 0 && third == 0 && fourth == 0) {
        return true;
      }
      return false;
    }
    String curr = first + "+" + second + "+" + third + "+" + fourth + "+" + index;
    if (dp.containsKey(curr)) {
      return dp.get(curr);
    }
    boolean one = solve(arr, first - arr[index], second, third, fourth, index + 1);
    boolean two = solve(arr, first, second - arr[index], third, fourth, index + 1);
    boolean three = solve(arr, first, second, third - arr[index], fourth, index + 1);
    boolean four = solve(arr, first, second, third, fourth - arr[index], index + 1);
    boolean ans = one || two || three || four;
    dp.put(curr, ans);
    return ans;
  }
}
