public class Third {
  public boolean canBeValid(String s, String locked) {
    if (s.length() % 2 != 0) {
      return false;
    }
    return solve(s, locked, '(') && solve(s, locked, ')');
  }

  public boolean solve(String s, String locked, char ch) {
    int balanced = 0;
    int unlocked = 0;
    int start = ch == '(' ? 0 : s.length() - 1;
    int dir = ch == '(' ? 1 : -1;
    for (int i = start; i >= 0 && i < s.length() && balanced + unlocked >= 0; i += dir) {
      if (locked.charAt(i) == '1') {
        balanced += s.charAt(i) == ch ? 1 : -1;
      } else {
        unlocked++;
      }
    }
    return Math.abs(balanced) <= unlocked;
  }
}
