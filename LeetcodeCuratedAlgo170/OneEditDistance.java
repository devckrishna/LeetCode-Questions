public class OneEditDistance {
  public boolean isOneEditDistance(String s, String t) {
    if (Math.abs(s.length() - t.length()) > 1) {
      return false;
    }
    int l1 = s.length();
    int l2 = t.length();
    int i = 0;
    int j = 0;
    while (i < l1 && j < l2 && s.charAt(i) == t.charAt(j)) {
      i++;
      j++;
    }
    if (i == l1 && j == l2) {
      return false;
    }
    if (l1 > l2) {
      return s.substring(i + 1).equals(t.substring(j));
    } else if (l1 < l2) {
      return s.substring(i).equals(t.substring(j + 1));
    } else {
      return s.substring(i + 1).equals(t.substring(j + 1));
    }
  }
}
