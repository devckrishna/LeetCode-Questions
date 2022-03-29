import java.util.Arrays;

public class Fourth {
  public String orderlyQueue(String s, int k) {
    if (k == 1) {
      String ans = s;
      for (int i = 0; i < s.length(); ++i) {
        String temp = s.substring(i) + s.substring(0, i);
        if (temp.compareTo(ans) < 0) {
          ans = temp;
        }
      }
      return ans;
    } else {
      char[] ans = s.toCharArray();
      Arrays.sort(ans);
      return new String(ans);
    }
  }
}
