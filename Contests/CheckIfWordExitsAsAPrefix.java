public class CheckIfWordExitsAsAPrefix {
  public int isPrefixOfWord(String sentence, String searchWord) {
    String[] words = sentence.split(" ");
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      for (int j = 0; j < word.length(); j++) {
        String curr = word.substring(0, j + 1);
        if (curr.equals(searchWord)) {
          return i + 1;
        }
      }
    }
    return -1;
  }
}
