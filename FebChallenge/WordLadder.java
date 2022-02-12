import java.util.*;

public class WordLadder {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Map<String, Boolean> map = new HashMap<>();
    for (String word : wordList) {
      map.put(word, false);
    }
    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);
    map.put(beginWord, true);

    int length = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        String cur = queue.remove();
        if (cur.equals(endWord)) {
          return length;
        }
        char[] curWordChar = cur.toCharArray();
        for (int i = 0; i < curWordChar.length; i++) {
          char old = curWordChar[i];
          for (char c = 'a'; c <= 'z'; c++) {
            curWordChar[i] = c;
            String nextStr = new String(curWordChar);
            Boolean mapRes = map.getOrDefault(nextStr, true);
            if (!mapRes) {
              queue.add(nextStr);
              map.put(nextStr, true);
            }
          }
          curWordChar[i] = old;
        }
      }
      length += 1;
    }
    return 0;
  }
}
