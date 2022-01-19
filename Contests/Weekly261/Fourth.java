public class Fourth {
  public String smallestSubsequence(String s, int k, char letter, int repetition) {
    int count = 0;
    for (char c : s.toCharArray()) {
      count += c == letter ? 1 : 0;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); count -= s.charAt(i++) == letter ? 1 : 0) {
      while (sb.length() + s.length() > i + k && sb.length() > 0 && s.charAt(i) < sb.charAt(sb.length() - 1)
          && (sb.charAt(sb.length() - 1) != letter || count != repetition)) {
        repetition += sb.charAt(sb.length() - 1) == letter ? 1 : 0;
        sb.setLength(sb.length() - 1);
      }
      if (k - sb.length() > Math.max(0, s.charAt(i) == letter ? 0 : repetition)) {
        sb.append(s.charAt(i));
        repetition -= s.charAt(i) == letter ? 1 : 0;
      }
    }
    return sb.toString();
  }
}
