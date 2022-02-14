public class AverageWaitingTime {
  public double averageWaitingTime(int[][] customers) {
    double time = 0d;
    int start = 0;
    int arrival = 0;

    for (int[] customer : customers) {
      arrival = customer[0];
      int curr = customer[1];
      start = Math.max(start, arrival);
      time += curr + (start - arrival);
      start += curr;
    }

    return time / customers.length;
  }
}
