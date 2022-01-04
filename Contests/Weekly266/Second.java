public class Second {
  public long countVowels(String word) {
    long ans = 0;
    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o'
          || word.charAt(i) == 'u') {
        ans += (long) (i + 1) * (long) (word.length() - i);
      }
    }

    return ans;
  }
}
