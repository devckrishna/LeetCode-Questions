import java.util.*;

public class NumberOfSmallestUnOccupiedChair {
  public static class Friend implements Comparable<Friend> {
    int arrival;
    int depart;
    int index;
    int chair;

    public Friend(int arrival, int depart, int index, int chair) {
      this.arrival = arrival;
      this.depart = depart;
      this.index = index;
      this.chair = chair;
    }

    @Override
    public int compareTo(Friend o) {
      return this.arrival - o.arrival;
    }
  }

  public int smallestChair(int[][] times, int targetFriend) {
    Friend[] arr = new Friend[times.length];
    for (int i = 0; i < times.length; i++) {
      int[] curr = times[i];
      arr[i] = new Friend(curr[0], curr[1], i, -1);
    }
    Arrays.sort(arr);
    for (int i = 0; i < arr.length - 1; i++) {
      int time = arr[i].arrival;
      int chair = arr[i].chair + 1;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j].arrival > time)
          arr[j].chair = chair;
      }
      arr[i].chair = chair;
      if (arr[i].index == targetFriend) {
        return arr[i].chair;
      }
    }
    return 0;
  }
}
