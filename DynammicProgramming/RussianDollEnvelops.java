import java.util.Arrays;

public class RussianDollEnvelops {
  public class Envelops implements Comparable<Envelops> {
    int h;
    int w;

    public Envelops(int h, int w) {
      this.h = h;
      this.w = w;
    }

    @Override
    public int compareTo(RussianDollEnvelops.Envelops o) {
      return this.w - o.w;
    }
  }

  public int maxEnvelopes(int[][] envelopes) {
    Envelops[] arr = new Envelops[envelopes.length];
    int x = 0;
    for (int[] num : envelopes) {
      arr[x++] = new Envelops(num[0], num[1]);
    }
    Arrays.sort(arr);
    int[] dp = new int[envelopes.length];
    for (int i = 0; i < arr.length; i++) {
      int max = 0;
      for (int j = 0; j < i; j++) {
        if (arr[j].h < arr[i].h && arr[j].w < arr[i].w) {
          if (dp[j] > max) {
            max = dp[j];
          }
        }
      }
      dp[i] = max + 1;
    }
    int omax = 0;
    for (int i = 0; i < dp.length; i++) {
      omax = Math.max(dp[i], omax);
    }
    return omax;
  }
}
