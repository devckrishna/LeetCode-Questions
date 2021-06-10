import java.util.*;

public class TopKFrequentwords {
  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> {
      if (map.get(s1) == map.get(s2)) {
        return s1.compareTo(s2);
      } else {
        return map.get(s2).compareTo(map.get(s1));
      }
    });

    for (String word : map.keySet()) {
      pq.offer(word);
    }

    List<String> result = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      result.add(pq.remove());
    }
    return result;
  }
}