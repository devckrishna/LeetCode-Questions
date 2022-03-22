import java.util.Arrays;

public class SmallestStringWithGivenSumValue {
  public String getSmallestString(int n, int k) {
    char[] ans = new char[n];
    Arrays.fill(ans, 'a');
    k -= n;
    for (int i = n - 1; i >= 0 && k > 0; i--) {
      int curr = Math.min(k, 25);
      ans[i] = (char) (ans[i] + curr);
      k -= curr;
    }
    
    return new String(ans);
  }
}
