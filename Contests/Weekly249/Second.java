import java.util.Arrays;

public class Second {
  public int countPalindromicSubsequence(String s) {
    int[] first = new int[26];
    int[] last = new int[26];
    Arrays.fill(first, Integer.MAX_VALUE);
    for (int i = 0; i < s.length(); i++) {
      int index = s.charAt(i) - 'a';
      first[index] = Math.min(first[index], i);
      last[index] = i;
    }
    int ans = 0;
    for (int i = 0; i < 26; i++) {
      if (first[i] < last[i]) {
        ans += s.substring(first[i] + 1, last[i]).chars().distinct().count();
      }
    }
    return ans;
  }
}
