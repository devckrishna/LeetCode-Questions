import java.util.*;

public class ZigZagConversion {
  public String convert(String s, int numRows) {
    if (numRows == 1)
      return s;
    List<StringBuilder> list = new ArrayList<>();
    for (int i = 0; i < Math.min(numRows, s.length()); i++) {
      list.add(new StringBuilder());
    }
    int row = 0;
    boolean turn = false;
    for (char ch : s.toCharArray()) {
      list.get(row).append(ch);
      if (row == 0 || row == numRows - 1) {
        turn = !turn;
      }
      row += turn ? 1 : -1;
    }
    StringBuilder sb = new StringBuilder();
    for (StringBuilder curr : list) {
      sb.append(curr);
    }
    return sb.toString();
  }
}