import java.util.*;

public class DestinationCity {
  public String destCity(List<List<String>> paths) {
    Map<String, String> map = new HashMap<>();
    for (List<String> city : paths) {
      map.put(city.get(0), city.get(1));
    }
    String des = "";
    for (List<String> curr : paths) {
      if (!map.containsKey(curr.get(1))) {
        des = curr.get(1);
        break;
      }
    }
    return des;
  }
}
