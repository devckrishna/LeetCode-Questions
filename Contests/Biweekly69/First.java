public class First {
  public String capitalizeTitle(String title) {
    StringBuilder sb = new StringBuilder();
    String[] curr = title.split(" ");
    for (String s : curr) {
      if (s.length() == 1) {
        sb.append(Character.toLowerCase(s.charAt(0)));
        sb.append(" ");
        continue;
      }
      if (s.length() == 2) {
        sb.append(Character.toLowerCase(s.charAt(0)));
        sb.append(Character.toLowerCase(s.charAt(1)));
        sb.append(" ");
        continue;
      }
      for (int i = 0; i < s.length(); i++) {
        if (i == 0) {
          sb.append(Character.toUpperCase(s.charAt(i)));

        } else {
          sb.append(Character.toLowerCase(s.charAt(i)));
        }
      }
      sb.append(" ");
    }
    String ans = sb.toString();
    return ans.substring(0, ans.length() - 1);
  }
}