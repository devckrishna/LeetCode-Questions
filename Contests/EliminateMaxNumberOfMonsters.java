import java.util.Arrays;

public class EliminateMaxNumberOfMonsters {

  public int eliminateMaximum(int[] dist, int[] speed) {
    int[] arr = new int[dist.length];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) Math.ceil(dist[i] * 1.0 / speed[i]);
    }
    Arrays.sort(arr);
    int ans = 0;
    for (int i = 0; i < dist.length; i++) {
      if (arr[i] > i) {
        ans++;
      } else {
        break;
      }
    }

    return ans;
  }
}
