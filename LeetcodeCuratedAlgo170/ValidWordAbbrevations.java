public class ValidWordAbbrevations {
  public boolean validWordAbbreviation(String word, String abbr) {
    if (word == null || abbr == null)
      return false;
    int num = 0;
    int index = 0;

    for (char c : abbr.toCharArray()) {
      if (c == '0' && num == 0)
        return false;
      if (c >= '0' && c <= '9') {
        num = num * 10 + (c - '0');
      } else {
        index += num;
        if (index >= word.length() || c != word.charAt(index))
          return false;
        num = 0;
        index++;
      }
    }

    return index + num == word.length() ? true : false;
  }
}
