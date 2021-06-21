public class AlphabetBoardPath {
  public String alphabetBoardPath(String target) {
    StringBuilder sb = new StringBuilder();
    int x = 0;
    int y = 0;
    for (char ch : target.toCharArray()) {
      int x1 = (ch - 'a') / 5;
      int y1 = (ch - 'a') % 5;

      while (x1 < x) {
        x--;
        sb.append('U');
      }
      while (y1 > y) {
        y++;
        sb.append('R');
      }
      while (y1 < y) {
        y--;
        sb.append('L');
      }
      while (x1 > x) {
        x++;
        sb.append('D');
      }
      sb.append('!');
    }
    return sb.toString();
  }
}
