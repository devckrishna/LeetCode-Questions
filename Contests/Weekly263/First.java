import java.util.*;

public class First {
  public boolean areNumbersAscending(String s) {
    List<Integer> arr = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      if (!Character.isDigit(s.charAt(i)))
        continue;
      int num = 0;
      while (i < s.length() && Character.isDigit(s.charAt(i))) {
        num = num * 10 + s.charAt(i) - '0';
        i++;
      }
      arr.add(num);
    }

    for (int i = 1; i < arr.size(); i++) {
      if (arr.get(i - 1) >= arr.get(i)) {
        return false;
      }
    }

    return true;
  }
}