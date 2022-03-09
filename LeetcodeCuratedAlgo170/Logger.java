import java.util.*;

public class Logger {
  Map<String, Integer> map;

  public Logger() {
    map = new HashMap<>();
  }

  public boolean shouldPrintMessage(int timestamp, String message) {
    if (map.containsKey(message)) {
      if (timestamp - map.get(message) < 10) {
        return false;
      } else {
        map.put(message, timestamp);
        return true;
      }
    } else {
      map.put(message, timestamp);
      return true;
    }
  }
}
