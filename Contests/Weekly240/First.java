import java.util.Arrays;

public class First {
  public int maximumPopulation(int[][] logs) {
    Arrays.sort(logs, (a, b) -> a[0] - b[0]);
    int[] arr = new int[201];
    int ans = 0;
    int year = 0;
    for (int[] log : logs) {
      for (int i = log[0] - 1950; i < log[1] - 1950; i++) {
        arr[i]++;
      }
      int max = 0;
      int index = 0;
      for (int i = 0; i < arr.length; i++) {

        if (arr[i] > max) {
          index = i + 1950;
          max = arr[i];
        }
      }
      System.out.println(max + " " + index);
      if (ans < max) {
        ans = max;
        year = index;
      }
    }
    return year;
  }
}