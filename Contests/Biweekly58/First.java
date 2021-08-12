public class First {
  public String makeFancyString(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length() - 1; i++) {
      int count = 1;
      char ch = s.charAt(i);
      while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
        i++;
        count++;
      }
      if (count <= 1) {
        sb.append(ch);
      } else {
        sb.append(ch);
        sb.append(ch);
      }
    }
    if (s.length() >= 2 && s.charAt(s.length() - 1) != s.charAt(s.length() - 2))
      sb.append(s.charAt(s.length() - 1));
    return sb.toString();
  }
}