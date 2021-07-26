public class SumDigitsOfStringAfterConvert {
  public int getLucky(String s, int k) {
    String curr = "";
    for (char ch : s.toCharArray()) {
      curr += ch - 'a' + 1;
    }
    while (k-- > 0) {
      int ans = 0;
      for (char ch : curr.toCharArray()) {
        ans += ch - '0';
      }
      curr = ans + "";
    }
    return Integer.parseInt(curr);
  }
}
