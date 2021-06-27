public class RemoveAllOccurencesOfAString {
  public String removeOccurrences(String s, String part) {
    while (true) {
      String curr = s.replaceFirst(part, "");
      if (s.equals(curr)) {
        break;
      }
      s = s.replaceFirst(part, "");
    }
    return s;
  }
  // public String removeOccurrences(String s, String part) {
  // if (part.length() == 1) {
  // return s.replace(part, "");
  // }
  // return solve(s, part);
  // }

  // public String solve(String s, String part) {
  // String ans = "";
  // for (int i = 0; i < s.length() - part.length() + 1; i++) {
  // String left = s.substring(i, i + part.length());
  // if (left.equals(part)) {
  // System.out.println(s.substring(0, i) + s.substring(i + part.length()));
  // ans = removeOccurrences(s.substring(0, i) + s.substring(i + part.length() +
  // 1), part);
  // }
  // }
  // if (ans == "") {
  // return s;
  // }
  // return ans;
  // }
}
