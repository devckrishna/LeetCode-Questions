public class ShortestWordDistance {
  public int shortestDistance(String[] wordsDict, String word1, String word2) {
    int first = -1;
    int second = -1;
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < wordsDict.length; i++) {
      String curr = wordsDict[i];
      if (curr.equals(word1)) {
        first = i;
      } else if (curr.equals(word2)) {
        second = i;
      }
      if (first != -1 && second != -1) {
        ans = Math.min(ans, Math.abs(first - second));
      }
    }
    return ans;
  }
}
