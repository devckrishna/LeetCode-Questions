public class DetectCapital {
  public boolean detectCapitalUse(String word) {
    boolean isCap = false;
    boolean isSmall = false;
    for (char ch : word.toCharArray()) {
      if (Character.isUpperCase(ch)) {
        isCap = true;
      } else {
        isSmall = true;
      }
    }
    if (isCap && isSmall) {
      for (int i = 1; i < word.length(); i++) {
        char ch = word.charAt(i);
        if (Character.isUpperCase(ch)) {
          return false;
        }
      }
      return true;
    } else if (!isCap && isSmall) {
      return true;
    } else if (isCap && !isSmall) {
      return true;
    }
    return false;
  }
}
