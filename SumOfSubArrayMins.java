import java.util.*;

public class SumOfSubArrayMins {
  public int sumSubarrayMins(int[] A) {
    long res = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i <= A.length; i++) {
      while (!stack.isEmpty() && (i == A.length || A[stack.peek()] > A[i])) {
        int mid = stack.pop(), L = mid - (stack.isEmpty() ? -1 : stack.peek()), R = i - mid;
        res += (long) A[mid] * L * R;
      }
      stack.push(i);
    }
    return (int) (res % 1_000_000_007);
  }

  // ---------------------MEMORY LIMIT EXCEEDED---------------
  int mod = (int) Math.pow(10, 9) + 7;

  public int sumSubarrayMins2(int[] arr) {
    long[][] dp = new long[arr.length][arr.length];
    long ans = 0;
    for (int g = 0; g < arr.length; g++) {
      for (int i = 0, j = g; j < arr.length; i++, j++) {
        if (g == 0) {
          dp[i][j] = arr[i];
        } else {
          dp[i][j] = Math.min(arr[i], Math.min(dp[i + 1][j], dp[i][j - 1]));
        }
        ans += dp[i][j] % mod;
      }
    }
    return (int) ans % mod;
  }
}
