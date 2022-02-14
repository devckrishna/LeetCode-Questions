public class Third {
  public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
    int min = targetSeconds / 60;
    int sec = targetSeconds % 60;
    long out = Long.MAX_VALUE;
    if (min < 100)
      out = Math.min(out, getCost(startAt, moveCost, pushCost, min * 100 + sec));
    if (sec < 40 && min > 0) {
      out = Math.min(out, getCost(startAt, moveCost, pushCost, (min - 1) * 100 + (sec + 60)));
    }
    return (int) out;
  }

  private long getCost(int n, int moveCost, int pushCost, int x) {
    long sum = 0;
    for (int i = 1; i < 4; i++) {
      int d = (int) Math.pow(10, i);
      if (x / d == 0) {
        x %= d;
      } else {
        break;
      }
    }
    String s = String.valueOf(x);
    for (char c : s.toCharArray()) {
      int e = c - '0';
      if (e != n) {
        sum += moveCost + pushCost;
      } else {
        sum += pushCost;
      }
      n = e;
    }
    return sum;
  }
}
