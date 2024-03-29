import java.util.*;

public class Second {
  public List<String> alertNames(String[] keyName, String[] keyTime) {
    Map<String, List<Integer>> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    for (int i = 0; i < keyName.length; i++) {
      String k = keyName[i];
      map.computeIfAbsent(k, g -> new ArrayList<>());
      map.get(k).add(getTime(keyTime[i]));
    }

    for (String k : map.keySet()) {
      List<Integer> l = map.get(k);
      Collections.sort(l);
      for (int i = 2; i < l.size(); i++)
        if (l.get(i) - l.get(i - 2) <= 60) {
          res.add(k);
          break;
        }
    }

    Collections.sort(res);
    return res;
  }

  private int getTime(String t) {
    String[] ss = t.split(":");
    return Integer.parseInt(ss[1]) + 60 * Integer.parseInt(ss[0]);
  }
}
