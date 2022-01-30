public class Third {
  public String subStrHash(String s, int power, int m, int k, int hashValue) {
    long[] powerArr = new long[k];
    int n = s.length();
    powerArr[0] = 1;
    for (int i = 1; i < powerArr.length; i++) {
      powerArr[i] = ((powerArr[i - 1] % m) * (power % m)) % m;
    }
    long currAns = 0;
    for (int i = n - 1; i >= n - k; i--) {
      int cVal = s.charAt(i) - 'a';
      cVal++;
      long val = ((cVal % m) * (powerArr[k - n + i] % m)) % m;
      currAns = ((currAns % m) + (val % m)) % m;
    }

    int ans = 0;
    if ((int) currAns == hashValue) {
      ans = n - k;
    }
    for (int i = n - k - 1; i >= 0; i--) {
      int cVal = s.charAt(i + k) - 'a';
      cVal++;
      long temp = ((cVal % m) * (powerArr[k - 1] % m)) % m;
      currAns -= temp;
      currAns += m;
      currAns %= m;
      currAns = ((currAns % m) * (power % m)) % m;
      cVal = (s.charAt(i) - 'a') + 1;
      currAns = ((currAns) % m + (cVal % m)) % m;
      if ((int) currAns == hashValue) {
        ans = i;
      }
    }

    return s.substring(ans, ans + k);
  }
}
