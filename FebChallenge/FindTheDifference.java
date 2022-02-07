public class FindTheDifference {
  public char findTheDifference(String s, String t) {
    int[] map = new int[26];
    for (char ch : s.toCharArray()) {
      map[ch - 'a']++;
    }
    for (char ch : t.toCharArray()) {
      if (map[ch - 'a'] == 0) {
        return ch;
      } else {
        map[ch - 'a']--;
      }
    }
    return 'a';
  }
}
