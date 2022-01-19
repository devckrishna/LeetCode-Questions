public class First {
  public int minimumMoves(String s) {
    int ans = 0;
    StringBuilder sb = new StringBuilder(s);
    for (int i = 0; i < s.length() - 2; i++) {
      if (sb.charAt(i) == 'O') {
        continue;
      }
      String curr = sb.substring(i, i + 3);
      if (!curr.equals("OOO")) {
        ans++;
      }
      sb.setCharAt(i, 'O');
      sb.setCharAt(i + 1, 'O');
      sb.setCharAt(i + 2, 'O');
    }
    if (!sb.substring(s.length() - 3, sb.length()).equals("OOO")) {
      ans++;
    }
    return ans;
  }
}