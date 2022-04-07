public class First {

  public int convertTime(String current, String correct) {
    int currTime = findTime(current);
    int target = findTime(correct);
    int ans = 0;
    while (currTime < target) {
      if (currTime + 60 <= target) {
        currTime += 60;
      } else if (currTime + 15 <= target) {
        currTime += 15;
      } else if (currTime + 5 <= target) {
        currTime += 5;
      } else {
        currTime++;
      }
      ans++;
    }
    return ans;
  }

  private int findTime(String s) {
    String[] curr = s.split(":");
    int hour = Integer.parseInt(curr[0]) * 60;
    return hour + Integer.parseInt(curr[1]);
  }
}