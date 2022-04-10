public class First {
  public int largestInteger(int num) {
    StringBuilder sb = new StringBuilder(num + "");
    for (int i = 0; i < sb.length() - 1; i++) {
      for (int j = i + 1; j < sb.length(); j++) {
        if (i == j) {
          continue;
        }
        int first = sb.charAt(i) - '0';
        int second = sb.charAt(j) - '0';
        if (first % 2 == second % 2 && second > first) {
          char temp = sb.charAt(i);
          sb.setCharAt(i, sb.charAt(j));
          sb.setCharAt(j, temp);
        }
      }
    }
    return Integer.parseInt(sb.toString());
  }
}