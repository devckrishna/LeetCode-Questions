public class ReplaceAllDigitsWithcharacter {
  public String replaceDigits(String s1) {

    char[] count = new char[26];
    for (int i = 97; i <= 122; i++) {
      count[i - 97] = (char) i;
    }
    String res = "";
    for (int i = 0; i < s1.length(); i++) {
      if ((i & 1) != 0) {
        char prev = s1.charAt(i - 1);
        int val = (s1.charAt(i) - '0');
        res += count[((prev - 97) + val) % 26];
      } else {
        res += String.valueOf(s1.charAt(i));
      }
    }

    return res;
  }

}