import java.util.Arrays;

public class Second {
  public int numberOfWeakCharacters(int[][] properties) {
    Arrays.sort(properties, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
    int ans = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < properties.length; i++) {
      if (properties[i][1] < max) {
        ans++;
      }
      max = Math.max(max, properties[i][1]);
    }
    return ans;
  }
}
