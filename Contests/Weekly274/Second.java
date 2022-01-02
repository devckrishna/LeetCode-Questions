public class Second {
  public int numberOfBeams(String[] bank) {
    int ans = 0;
    int count = 0;
    for (String curr : bank) {
      int currCount = 0;
      for (char ch : curr.toCharArray()) {
        if (ch == '1') {
          currCount++;
        }
      }
      if (currCount == 0) {
        continue;
      } else {
        ans += currCount * count;
        count = currCount;
      }

    }
    return ans;
  }
}
