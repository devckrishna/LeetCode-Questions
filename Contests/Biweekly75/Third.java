public class Third {
  public long numberOfWays(String s) {
    long ones = 0;
    long zeros = 0;
    long oneZero = 0;
    long zeroOne = 0;
    long ans = 0;
    for (char ch : s.toCharArray()) {
      if (ch == '0') {
        zeros++;
        oneZero += ones;
        ans += zeroOne;
      } else {
        ones++;
        zeroOne += zeros;
        ans += oneZero;
      }
    }
    return ans;
  }
}
