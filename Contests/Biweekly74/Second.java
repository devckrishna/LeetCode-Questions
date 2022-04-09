public class Second {
  public long maximumSubsequenceCount(String text, String pattern) {
    long first = 0;
    long second = 0;
    long ans = 0;
    for (char ch : text.toCharArray()) {
      if (ch == pattern.charAt(1)) {
        ans += first;
        second++;
      }
      if (ch == pattern.charAt(0)) {
        first++;
      }
    }
    return ans + Math.max(first, second);
  }
}
