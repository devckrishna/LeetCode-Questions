import java.util.*;

public class Second {
  public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
    Set<String> set = new HashSet<>();
    for (int[] d : dig) {
      set.add(d[0] + "@" + d[1]);
    }
    int ans = 0;
    for (int[] art : artifacts) {
      boolean isFound = true;
      for (int i = art[0]; i <= art[2]; i++) {
        for (int j = art[1]; j <= art[3]; j++) {
          if (!set.contains(i + "@" + j)) {
            isFound = false;
            break;
          }
        }
      }
      if (isFound) {
        ans++;
      }
    }
    return ans;
  }
}
