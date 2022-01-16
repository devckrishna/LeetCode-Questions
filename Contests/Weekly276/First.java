import java.util.ArrayList;

import java.util.*;

public class First {
  public String[] divideString(String s, int k, char fill) {
    List<String> arr = new ArrayList<>();
    int i = 0;
    for (i = 0; i < s.length() - k - 1; i += k) {
      arr.add(s.substring(i, i + k));
    }
    i -= k;
    if (s.length() % k != 0) {
      String curr = "";
      while (i < s.length()) {
        curr += s.charAt(i);
        i++;
      }
      int temp = k - curr.length();
      while (temp-- > 0) {
        curr += fill;
      }
      arr.add(curr);
    }
    String[] ans = new String[arr.size()];
    for (int x = 0; x < ans.length; x++) {
      ans[x] = arr.get(x);
    }
    return ans;
  }
}