import java.util.*;

public class First {
  public int[] findEvenNumbers(int[] digits) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < digits.length; i++) {
      if (digits[i] == 0) {
        continue;
      }
      for (int j = 0; j < digits.length; j++) {
        if (i == j) {
          continue;
        }
        for (int k = 0; k < digits.length; k++) {
          if (j == k || i == k || digits[k] % 2 != 0) {
            continue;
          }
          int num = Integer.parseInt(digits[i] + "" + digits[j] + "" + digits[k]);
          if (num % 2 == 0) {
            set.add(num);
          }
        }
      }
    }
    int[] ans = new int[set.size()];
    int index = 0;
    for (int curr : set) {
      ans[index] = curr;
      index++;
    }
    Arrays.sort(ans);
    return ans;
  }
}