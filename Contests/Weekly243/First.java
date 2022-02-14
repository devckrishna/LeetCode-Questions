public class First {
  public int findNum(String s) {
    String curr = "";
    int index = 0;
    while (index < s.length()) {
      curr += s.charAt(index) - 'a';
      index++;
    }
    return Integer.parseInt(curr);
  }

  public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
    int first = findNum(firstWord);
    int second = findNum(secondWord);
    int third = findNum(targetWord);
    return first + second == third;
  }
}