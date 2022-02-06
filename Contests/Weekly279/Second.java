import java.util.*;

public class Second {
  public long smallestNumber(long num) {
    boolean isNeg = false;
    if (num < 0) {
      isNeg = true;
      num *= -1;
    }
    Set<Integer> set = new HashSet<>();
    String curr = num + "";
    for (char ch : curr.toCharArray()) {
      set.add(ch - '0');
    }
    int first = -1;
    String ans = "";
    if (isNeg) {
      List<Integer> arr = new ArrayList<>();
      for (char ch : curr.toCharArray()) {
        arr.add(ch - '0');
      }
      Collections.sort(arr, Collections.reverseOrder());
      for (int n : arr) {
        ans += n;
      }
    } else {
      for (int i = 1; i <= 9; i++) {
        if (set.contains(i)) {
          ans += i;
          first = i;
          break;
        }
      }
      List<Integer> arr = new ArrayList<>();
      boolean found = false;
      for (char ch : curr.toCharArray()) {
        int val = ch - '0';
        if (val == first && !found) {
          found = true;
          continue;
        }
        arr.add(val);
      }
      Collections.sort(arr);
      for (int n : arr) {
        ans += n;
      }
    }
    return isNeg ? -Long.parseLong(ans) : Long.parseLong(ans);
  }
}