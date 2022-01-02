public class First {
  public boolean checkString(String s) {
    boolean flag = false;
    for (char ch : s.toCharArray()) {
      if (ch == 'b') {
        flag = true;
      }
      if (ch == 'a' && flag) {
        return false;
      }
    }
    return true;
  }
}