public class First {
  public int timeRequiredToBuy(int[] tickets, int k) {
    int ans = 0;
    for (int i = 0; i <= k; i++) {
      ans++;
      tickets[i]--;
    }
    while (tickets[k] > 0) {
      int time = 0;
      for (int i = 0; i < tickets.length; i++) {
        if (tickets[i] != 0) {
          time++;
          tickets[i]--;
        }
      }
      ans += time;
    }
    return ans;
  }
}