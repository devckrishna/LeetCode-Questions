import java.util.*;

public class Fourth {
  public long coutPairs(int[] nums, int k) {
    long ans = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int gcd = findGcd(nums[i], k);
      for (int num : map.keySet()) {
        if ((long) gcd * num % k == 0) {
          ans += map.get(num);
        }
      }
      map.put(gcd, map.getOrDefault(gcd, 0) + 1);
    }
    return ans;
  }

  public int findGcd(int a, int b) {
    if (a < b) {
      return findGcd(b, a);
    }
    return b == 0 ? a : findGcd(b, a % b);
  }
}
