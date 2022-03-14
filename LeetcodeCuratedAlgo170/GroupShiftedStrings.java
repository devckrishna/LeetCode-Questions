import java.util.*;

public class GroupShiftedStrings {
  public List<List<String>> groupStrings(String[] strings) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strings) {
      String key = getKey(str);
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }
      map.get(key).add(str);
    }
    List<List<String>> ans = new ArrayList<>();
    for (String key : map.keySet()) {
      ans.add(map.get(key));
    }
    return ans;
  }

  public String getKey(String str) {
    String key = "";
    for (int i = 1; i < str.length(); i++) {
      int offSet = str.charAt(i) - str.charAt(i - 1);
      if (offSet < 0) {
        offSet += 26;
      }
      key += offSet + "@";
    }

    return key;
  }
}
