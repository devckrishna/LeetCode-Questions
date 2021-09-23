public class First {
  public int minOperations(String s) {
    String first = "";
    String second = "";
    boolean dir = false;
    for (int i = 0; i < s.length(); i++) {
      if (dir) {
        first += '0';
        second += '1';
      } else {
        first += '1';
        second += '0';
      }
      dir = !dir;
    }
    int firstCount = 0;
    int secondCount = 0;
    for (int i = 0; i < s.length(); i++) {
      if (first.charAt(i) != s.charAt(i)) {
        firstCount++;
      }
    }
    for (int i = 0; i < s.length(); i++) {
      if (second.charAt(i) != s.charAt(i)) {
        secondCount++;
      }
    }
    return Math.min(firstCount, secondCount);
  }
}