import java.util.*;

public class SubArraySumDivisibleByK {
  public int subarraysDivByK(int[] A, int K) {
    int ans = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int sum = 0;
    int rem = 0;
    for (int i = 0; i < A.length; i++) {
      sum += A[i];
      rem = sum % K;
      if (rem < 0) {
        rem = rem + K;
      }
      if (map.containsKey(rem)) {
        ans += map.get(rem);
        map.put(rem, map.get(rem) + 1);
      } else {
        map.put(rem, 1);
      }
    }
    return ans;
  }
}
