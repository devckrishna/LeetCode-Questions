public class CheckIfStringIsPrefixArray {
  public boolean isPrefixString(String s, String[] words) {
    String temp = "";
    for (String curr : words) {
      temp += curr;
      if (s.equals(temp)) {
        return true;
      }
    }
    return false;
  }
}