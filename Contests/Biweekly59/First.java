public class First {
  public int minTimeToType(String word) {
    int ans = 0;
    char index = 'a';
    for (char ch : word.toCharArray()) {
      if (ch > index) {
        int second = ch - index;
        int first = 26 - second;
        ans += 1 + Math.min(first, second);
      } else if (ch < index) {
        int second = index - ch;
        int first = 26 - second;
        ans += 1 + Math.min(first, second);
      } else {
        ans += 1;
      }
      index = ch;
    }
    return ans;
  }
}