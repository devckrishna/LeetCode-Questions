public class atoi {
  public static int atoi2(String str) {
    if (str.length() == 0) {
      return 0;
    }
    int num = 0;
    int index = 0;
    int sign = 1;
    int signCount = 0;
    while (str.charAt(index) == ' ' && index < str.length()) {
      index++;
    }
    if (str.charAt(index) == '+') {
      signCount++;
      index++;
    }
    if (str.charAt(index) == '-') {
      signCount++;
      sign = -1;
      index++;
    }
    if (signCount >= 2) {
      return 0;
    }
    while (index < str.length()) {
      char ch = str.charAt(index);
      if (ch < '0' || ch > '9')
        break;
      if (Integer.MAX_VALUE / 10 < num || Integer.MAX_VALUE / 10 == num && Integer.MAX_VALUE % 10 < (ch - '0')) {
        return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }
      num = num * 10 + (ch - '0');
      index++;
    }
    return sign * num;
  }
}
