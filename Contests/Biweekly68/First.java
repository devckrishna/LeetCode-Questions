public class First {
  public int mostWordsFound(String[] sentences) {
    int ans = 0;
    for (String curr : sentences) {
      int temp = 0;
      boolean flag = false;
      for (char ch : curr.toCharArray()) {
        if (ch == ' ' && flag) {
          temp++;
        } else {
          flag = true;
        }
      }
      ans = Math.max(ans, temp + 1);
    }

    return ans;
  }
}