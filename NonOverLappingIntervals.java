import java.util.Arrays;

public class NonOverLappingIntervals {
  class Interval implements Comparable<Interval> {
    int start;
    int end;

    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Interval o) {
      return this.end - o.end;
    }

  }

  public int eraseOverlapIntervals(int[][] intervals) {
    Interval[] arr = new Interval[intervals.length];
    int i = 0;
    for (int[] in : intervals) {
      arr[i] = new Interval(in[0], in[1]);
      i++;
    }
    return solve(arr);
  }

  public int solve(Interval[] arr) {
    Arrays.sort(arr);
    int curr = arr[0].end;
    int count = 1;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i].start >= curr) {
        curr = arr[i].end;
        count++;
      }
    }
    return arr.length - count;
  }
}
