public class Second {
  public String maxValue(String n, int x) {
    char c = n.charAt(0);
    if (c != '-') {
      for (int i = 0; i < n.length(); i++) {
        c = n.charAt(i);
        int num = c - 48;
        if (num < x)
          return n.substring(0, i) + x + n.substring(i);
      }
    } else {
      for (int i = 0; i < n.length(); i++) {
        c = n.charAt(i);
        int num = c - 48;
        if (num > x)
          return n.substring(0, i) + x + n.substring(i);
      }
    }
    return n + x;
  }
}
