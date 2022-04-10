public class First {
  public String firstPalindrome(String[] words) {
    for (String word : words) {
      String curr = reverse(word);
      if (curr.equals(word)) {
        return word;
      }
    }
    return "";
  }

  public String reverse(String s) {
    String ans = "";
    for (int i = s.length() - 1; i >= 0; i--) {
      ans += s.charAt(i);
    }
    return ans;
  }
}