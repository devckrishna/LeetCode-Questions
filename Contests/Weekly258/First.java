public class First {
  public String reversePrefix(String word, char ch) {
    char[] arr = word.toCharArray();
    int index = 0;
    for (int i = 0; i < word.length(); i++) {
      if (ch == arr[i]) {
        index = i;
        break;
      }
    }
    char[] ans = new char[word.length()];
    for (int i = 0; i <= index; i++) {
      ans[i] = arr[index - i];
    }
    for (int i = index + 1; i < word.length(); i++) {
      ans[i] = arr[i];
    }
    return String.valueOf(ans);
  }
}