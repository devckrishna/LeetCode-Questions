class ExpensiveWords {
  public int expressiveWords(String S, String[] words) {
    int count = 0;
    for (int i = 0; i < words.length; i++) {
      if (stretchy(S, words[i])) {
        count++;
      }
    }
    return count;
  }

  public static boolean stretchy(String S, String word) {
    if (word == null) {
      return false;
    }
    int i = 0;
    int j = 0;
    while (i < S.length() && j < word.length()) {
      if (S.charAt(i) == word.charAt(j)) {
        int len1 = getRepeated(S, i);
        int len2 = getRepeated(word, j);

        if (len1 < 3 && len1 != len2 || len1 >= 3 && len1 < len2) {
          return false;
        }
        i += len1;
        j += len2;
      } else {
        return false;
      }
    }
    return i == S.length() && j == word.length();
  }

  public static int getRepeated(String word, int i) {
    int j = i;
    while (j < word.length() && word.charAt(j) == word.charAt(i)) {
      j++;
    }
    return j - i;
  }

}