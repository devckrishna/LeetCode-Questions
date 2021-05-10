import java.util.*;

public class CheckIfArraypairIsDivisibleByK {
  // OPTIMAL------------------------------------
  public boolean canArrange(int[] arr, int k) {
    int[] frequency = new int[k];
    for (int num : arr) {
      num %= k;
      if (num < 0)
        num += k;
      frequency[num]++;
    }
    if (frequency[0] % 2 != 0)
      return false;

    for (int i = 1; i <= k / 2; i++)
      if (frequency[i] != frequency[k - i])
        return false;

    return true;
  }

  public boolean canArrange2(int[] arr, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      int rem = arr[i] % k;
      if (rem < k) {
        rem += k;
      }
      map.put(rem, map.getOrDefault(rem, 0) + 1);
    }
    for (int i = 0; i < arr.length; i++) {
      int rem = arr[i] % k;
      if (rem < 0) {
        rem += k;
      }
      if (rem == 0) {
        int fq = map.get(rem);
        if (fq % 2 == 1) {
          return false;
        }
      } else if (2 * rem == k) {
        int fq = map.get(rem);
        if (fq % 2 == 1) {
          return false;
        }
      } else {
        int fq = map.get(rem);
        int ofq = map.getOrDefault(k - rem, -1);
        if (fq != ofq) {
          return false;
        }
      }
    }
    return true;
  }

}
