public class CheckIfWordEqualsSummation {
  public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
    return getIntVal(firstWord) + getIntVal(secondWord) == getIntVal(targetWord);
  }

  private int getIntVal(String str) {
    int result = 0;
    for (int i = 0; i < str.length(); i++) {
      result = result * 10 + str.charAt(i) - 97;
    }
    return result;
  }
}
