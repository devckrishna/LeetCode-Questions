public class MnimumSwapsToGroupAllOnesTogeather {
  public int minSwaps(int[] data) {
    int ans = Integer.MAX_VALUE;
    int ones = 0;
    for (int curr : data) {
      if (curr == 1) {
        ones++;
      }
    }
    int window = 0;
    for (int i = 0; i < ones; i++) {
      window += data[i];
    }
    ans = Math.min(ones - window, ans);
    for (int i = ones; i < data.length; i++) {
      window += data[i];
      window -= data[i - ones];
      ans = Math.min(ones - window, ans);
    }
    return ans;
  }
}
