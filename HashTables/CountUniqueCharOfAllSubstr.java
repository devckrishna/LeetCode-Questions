public class CountUniqueCharOfAllSubstr {
  public int uniqueLetterString(String s) {
    final int MOD = 1000000007;
    int res = 0, dp = 0;
    int[] first = new int[26], second = new int[26];

    for (int i = 0; i < s.length(); i++) {
      int ci = s.charAt(i) - 'A';
      dp = dp + 1 + i - first[ci] * 2 + second[ci];
      res = (res + dp) % MOD;

      second[ci] = first[ci];
      first[ci] = i + 1;
    }

    return res;
  }
}
